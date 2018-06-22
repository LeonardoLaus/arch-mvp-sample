package ext.android.arch.mvp.sample.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

import ext.android.arch.lifecycle.rxjava2.RxLifecycleObserver;

public class MainObserver extends RxLifecycleObserver {
    public MainObserver(@NonNull Lifecycle lifecycle) {
        super(lifecycle);
    }

    @Override
    public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
        super.onAnyLifecycle(owner, event);
        Log.d("Test", "owner=" + owner + ", event=" + event);
    }
}
