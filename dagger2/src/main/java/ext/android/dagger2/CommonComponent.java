package ext.android.dagger2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@ActivityScope
@Component(modules = CommonModule.class)
public interface CommonComponent {
    void inject(DaggerActivity activity);
}
