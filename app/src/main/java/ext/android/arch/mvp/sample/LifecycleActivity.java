package ext.android.arch.mvp.sample;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import ext.android.arch.lifecycle.rxjava2.RxLifecycleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LifecycleActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        findViewById(R.id.btn_fragment_add).setOnClickListener(this::onClick);
        LifecycleObserver presenter = new LifecycleObserver();
        getLifecycle().addObserver(presenter);
        presenter.lifecycle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(event -> Log.v("Test", "LifecycleActivity lifecycle changed. " + event));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fragment_add:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new LifecycleFragment())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    private static class LifecycleObserver extends RxLifecycleObserver {
        @Override
        public void onAnyLifecycle(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
            super.onAnyLifecycle(owner, event);
            Log.i("Test", "[LifecycleObserver] onAnyLifecycle. event=[" + event + "] owner=[" + owner + "]");
        }
    }
}
