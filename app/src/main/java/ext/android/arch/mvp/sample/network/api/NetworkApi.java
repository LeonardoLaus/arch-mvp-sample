package ext.android.arch.mvp.sample.network.api;

import ext.android.arch.mvp.sample.network.MovieEntity;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkApi {
    //    http://api.douban.com
    @GET("/v2/movie/in_theaters")
    Observable<MovieEntity> movieInTheaters(@Query("start") int start,
                                            @Query("count") int count);
}
