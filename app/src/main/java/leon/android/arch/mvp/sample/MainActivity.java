package leon.android.arch.mvp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import leon.android.arch.mvp.sample.lifecycle.MainPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getLifecycle().addObserver(new MainPresenter());
    }
}
