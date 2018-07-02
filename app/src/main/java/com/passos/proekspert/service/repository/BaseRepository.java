package com.passos.proekspert.service.repository;


import android.support.annotation.NonNull;

import com.passos.proekspert.service.NetworkRemoteClient;
import com.passos.proekspert.service.RemoteClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseRepository {

    private final List<RemoteClient> remoteClientList = new ArrayList<>();

    protected <T> NetworkRemoteClient<T> addRemoteClient(NetworkRemoteClient<T> remoteClient) {
        remoteClientList.add(remoteClient);
        return remoteClient;
    }

    protected final Callback<?> EMPTY_CALLBACK = new Callback<Object>() {
        @Override
        public void onResponse(@NonNull Call<Object> call, @NonNull Response<Object> response) {
        }

        @Override
        public void onFailure(@NonNull Call<Object> call, @NonNull Throwable throwable) {
        }
    };

    public void dispose() {
        Iterator<RemoteClient> iterator = remoteClientList.iterator();
        while (iterator.hasNext()) {
            RemoteClient remoteClient = iterator.next();
            remoteClient.cancel();
            iterator.remove();
        }
    }

}