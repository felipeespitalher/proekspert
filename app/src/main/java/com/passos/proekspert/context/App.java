package com.passos.proekspert.context;

import android.app.Application;
import android.support.annotation.NonNull;

import com.crashlytics.android.BuildConfig;
import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.core.CrashlyticsCore;
import com.passos.proekspert.di.AppComponent;
import com.passos.proekspert.di.AppContext;
import com.passos.proekspert.di.AppModule;
import com.passos.proekspert.di.PersistenceModule;

import io.fabric.sdk.android.Fabric;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppContext.setComponent(buildAppComponent());
        initFabric();
    }

    @NonNull
    protected AppComponent buildAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .persistenceModule(new PersistenceModule(this))
                .build();
    }

    private void initFabric() {
        Crashlytics crashlytics = new Crashlytics.Builder()
                .core(new CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
                .build();
        Fabric.with(this, crashlytics);
    }
}
