package com.passos.proekspert.service;

import android.support.annotation.NonNull;

import java.io.IOException;

import io.fabric.sdk.android.Fabric;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class NetworkRemoteClient<T> implements RemoteClient<T> {

    private final Call<T> call;

    public NetworkRemoteClient(Call<T> call) {
        this.call = call;
    }

    @Override
    public void execute(final RemoteClientCallback<T> callback) {
        callback.onStart();
        call.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
                if (call.isCanceled()) {
                    return;
                }
                callback.onComplete();
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(toOperationStatus(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
                if (call.isCanceled()) {
                    return;
                }
                callback.onComplete();
                callback.onError("It's seems like that you have problems with connection");
            }
        });
    }

    private String toOperationStatus(ResponseBody responseBody) {
        try {
            if (Fabric.isInitialized()) {
                Fabric.getLogger().e(getClass().getName(), responseBody.string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "We could not identify what happened";
    }

    @Override
    public void cancel() {
        call.cancel();
    }
}
