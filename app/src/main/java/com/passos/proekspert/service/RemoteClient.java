package com.passos.proekspert.service;

public interface RemoteClient<T> {

    void execute(RemoteClientCallback<T> callback);

    void cancel();

}
