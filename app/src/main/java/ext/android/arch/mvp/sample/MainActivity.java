package ext.android.arch.mvp.sample;

import android.arch.lifecycle.Lifecycle;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import ext.android.arch.lifecycle.rxjava2.RxLifecycleObserver;
import ext.android.arch.mvp.sample.lifecycle.MainObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxLifecycleObserver presenter = new MainObserver();
        getLifecycle().addObserver(presenter);
        presenter.lifecycle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(presenter.bindUntilEvent(Lifecycle.Event.ON_DESTROY))
                .subscribe(event -> Log.e("Test", "activity lifecycle  current event: " + event));
    }

    public void onClick(View view) {
        startActivity(new Intent(this, LifecycleActivity.class));
    }
}
