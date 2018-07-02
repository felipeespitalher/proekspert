package com.passos.proekspert.service;

import com.passos.proekspert.ui.NetworkView;

public abstract class RemoteClientCallback<T> {

    private NetworkView view;

    public RemoteClientCallback() {
    }

    public RemoteClientCallback(NetworkView view) {
        this.view = view;
    }

    public void onStart() {
        if (view != null) {
            view.onCallStart();
        }
    }

    public void onComplete() {
        if (view != null) {
            view.onCallComplete();
        }
    }

    public void onError(String message) {
        if (view != null) {
            view.onCallError(message);
        }
    }

    public abstract void onSuccess(T data);

}
