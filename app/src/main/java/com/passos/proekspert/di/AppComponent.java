package com.passos.proekspert.di;

import com.passos.proekspert.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, PersistenceModule.class})
public interface AppComponent {

    void inject(MainActivity activity);

}
