package ext.android.arch.mvp.sample.mvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

import javax.inject.Inject;

import ext.android.arch.lifecycle.rxjava2.RxLifecycleObserver;
import ext.android.arch.mvp.BasePresenter;

public class MainPresenter extends RxLifecycleObserver implements BasePresenter {
    @Inject
    public MainPresenter(@NonNull Lifecycle lifecycle) {
        super(lifecycle);
    }

    @Override
    public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
        super.onAnyLifecycle(owner, event);
        Log.d("Test", "owner=" + owner + ", event=" + event);
    }
}
