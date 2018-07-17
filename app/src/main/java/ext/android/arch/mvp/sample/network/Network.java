package ext.android.arch.mvp.sample.network;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public final class Network {

    private static volatile Network _instance;
    private final Map<String, Object> apiCaches;

    private Network() {
        apiCaches = new ConcurrentHashMap<>();
    }

    public static synchronized Network get() {
        if (_instance == null) {
            synchronized (Network.class) {
                if (_instance == null) {
                    _instance = new Network();
                }
            }
        }
        return _instance;
    }

    public <T> T getService(Class<T> tClass) {
        final String className = tClass.getCanonicalName();
        if (apiCaches.get(className) == null) {
            apiCaches.put(className, createService(tClass));
        }
        return (T) apiCaches.get(className);
    }

    private static <T> T createService(Class<T> tClass) {
        final OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor())
                .build();
        return new Retrofit.Builder()
                .baseUrl("http://api.douban.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(tClass);
    }

    private static Interceptor loggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

}
