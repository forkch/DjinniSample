package ch.fork.djinnisample;

import android.app.Application;

import timber.log.Timber;

/**
 * Created with love by fork on 28.07.15.
 */
public class DjinniDemoApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }
}
