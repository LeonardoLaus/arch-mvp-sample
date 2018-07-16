package ext.android.arch.mvp.sample.dagger2;

import dagger.Component;
import ext.android.arch.mvp.sample.MainActivity;
import ext.android.dagger2.ActivityScope;

@ActivityScope
@Component(modules = MVPModule.class)
public interface MVPComponent {
    void inject(MainActivity activity);
}
