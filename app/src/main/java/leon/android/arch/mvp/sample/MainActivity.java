package leon.android.arch.mvp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import leon.android.arch.lifecycle.rxjava2.RxLifecyclePresenter;
import leon.android.arch.mvp.sample.lifecycle.MainPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxLifecyclePresenter presenter = new MainPresenter();
        getLifecycle().addObserver(presenter);
        presenter.lifecycle()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(event -> Log.e("Test", "activity lifecycle  current event: " + event));
    }
}
