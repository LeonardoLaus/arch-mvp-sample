package ext.android.dagger2;

import android.util.Log;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ext.android.dagger2.entity.Person;

@Module
class CommonModule {
    private static final String TAG = "Dagger";

    @Singleton
    @Provides
    Person providersPerson() {
        Log.v(TAG, "providersPerson");
        return new Person();
    }
}
