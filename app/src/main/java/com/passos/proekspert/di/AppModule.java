package com.passos.proekspert.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.passos.proekspert.BuildConfig;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @NonNull
    @Provides
    @Reusable
    Context providesContext() {
        return application.getBaseContext();
    }

    @NonNull
    @Provides
    @Reusable
    SharedPreferences providesSharedPreferences(Context context) {
        return context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

    }

}
