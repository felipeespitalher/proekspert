package com.passos.proekspert.persistence.dao;


import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T object);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<T> object);

    @Delete
    void delete(T object);
}
