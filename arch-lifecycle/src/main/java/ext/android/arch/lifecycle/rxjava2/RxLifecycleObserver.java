package ext.android.arch.lifecycle.rxjava2;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import ext.android.arch.lifecycle.BaseLifecycleObserver;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class RxLifecycleObserver extends BaseLifecycleObserver implements IRxLifecycleBinding<Lifecycle.Event> {

    private final BehaviorSubject<Lifecycle.Event> mLifecycleSubject = BehaviorSubject.create();

    public RxLifecycleObserver(@NonNull Lifecycle lifecycle) {
        super(lifecycle);
    }

    @CallSuper
    @Override
    public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
        mLifecycleSubject.onNext(event);
    }

    @Override
    public final <T> LifecycleTransformer<T> bindUntilEvent(Observable<Lifecycle.Event> lifecycle, Lifecycle.Event event) {
        return RxLifecycle.bindUntilEvent(lifecycle, event);
    }

    @Override
    public final <T> LifecycleTransformer<T> bindUntilEvent(Lifecycle.Event event) {
        return bindUntilEvent(mLifecycleSubject, event);
    }

    @Override
    public final Observable<Lifecycle.Event> lifecycle() {
        return mLifecycleSubject.hide();
    }
}
