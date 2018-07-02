package com.passos.proekspert.di;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.passos.proekspert.persistence.AppDatabase;
import com.passos.proekspert.persistence.dao.MatchDao;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class PersistenceModule {

    private final Application application;

    public PersistenceModule(Application application) {
        this.application = application;
    }

    @Provides
    @Reusable
    public AppDatabase providesAppDatabase() {
        String dbName = "proekspert-database";
        return Room.databaseBuilder(application, AppDatabase.class, dbName).build();
    }


    @Provides
    @Reusable
    public MatchDao providesResponsibleDao(AppDatabase appDatabase) {
        return appDatabase.predictionDao();
    }

}
