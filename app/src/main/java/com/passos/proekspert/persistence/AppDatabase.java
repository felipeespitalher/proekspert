package com.passos.proekspert.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.passos.proekspert.persistence.dao.MatchDao;
import com.passos.proekspert.persistence.domain.Match;

@Database(entities = {Match.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MatchDao predictionDao();

}
