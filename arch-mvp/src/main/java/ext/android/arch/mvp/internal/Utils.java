package ext.android.arch.mvp.internal;


import java.lang.reflect.Constructor;

import ext.android.arch.mvp.BasePresenter;

final class Utils {

    private Utils() {
        throw new AssertionError("no instance.");
    }

    public static <P extends BasePresenter> P createPresenter(Class<P> pClass, Object... params) {
        try {
            if (params == null || params.length == 0) {
                return pClass.newInstance();
            } else {
                Class[] paramTypes = new Class[params.length];
                for (int i = 0; i < params.length; i++) {
                    paramTypes[i] = params[i].getClass();
                }
                Constructor<P> constructor = pClass.getConstructor(paramTypes);
                return constructor.newInstance(params);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
