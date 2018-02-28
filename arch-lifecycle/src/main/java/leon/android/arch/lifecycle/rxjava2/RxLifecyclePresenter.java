package leon.android.arch.lifecycle.rxjava2;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import leon.android.arch.lifecycle.BaseLifecyclePresenter;

public class RxLifecyclePresenter extends BaseLifecyclePresenter implements IRxLifecycleBinding<Lifecycle.Event> {

    private final BehaviorSubject<Lifecycle.Event> mLifecycleSubject = BehaviorSubject.create();

    @CallSuper
    @Override
    public void onAny(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
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
