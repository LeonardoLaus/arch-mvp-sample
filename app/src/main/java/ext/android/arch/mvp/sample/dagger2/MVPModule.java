package ext.android.arch.mvp.sample.dagger2;

import android.arch.lifecycle.Lifecycle;

import dagger.Module;
import dagger.Provides;
import ext.android.arch.mvp.sample.network.Network;
import ext.android.arch.mvp.sample.network.api.NetworkApi;

@Module
public class MVPModule {
    Lifecycle lifecycle;

    public MVPModule(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    @Provides
    Lifecycle providersLifecycle() {
        return this.lifecycle;
    }

//    @Provides
//    MainPresenter providersPresenter(Lifecycle lifecycle) {
//        return new MainPresenter(lifecycle);
//    }

    @Provides
    NetworkApi providersNetworkApi() {
        return Network.get().getService(NetworkApi.class);
    }
}
