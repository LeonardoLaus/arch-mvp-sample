package leon.android.arch.mvp.sample.lifecycle;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.NonNull;
import android.util.Log;

import leon.android.arch.lifecycle.rxjava2.RxLifecyclePresenter;

/**
 * Created by roothost on 2018/2/27.
 */

public class MainPresenter extends RxLifecyclePresenter {
    @Override
    public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
        super.onAnyLifecycle(owner, event);
        Log.d("Test", "owner=" + owner + ", event=" + event);
    }
}
