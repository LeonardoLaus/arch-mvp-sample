package ext.android.arch.mvp.sample;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ext.android.arch.lifecycle.rxjava2.RxLifecycleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LifecycleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LifecycleFragmentObserver presenter = new LifecycleFragmentObserver(getLifecycle());
        presenter.lifecycle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(event -> Log.v("Test", "fragment lifecycle changed. " + event));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lifecycle, container, false);
    }

    private static class LifecycleFragmentObserver extends RxLifecycleObserver {
        public LifecycleFragmentObserver(@NonNull Lifecycle lifecycle) {
            super(lifecycle);
        }

        @Override
        public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
            super.onAnyLifecycle(owner, event);
            Log.i("Test", "[LifecycleFragmentObserver] onAnyLifecycle. event=[" + event + "] owner=[" + owner + "]");
        }
    }
}
