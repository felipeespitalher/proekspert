package com.passos.proekspert.ui;

public interface NetworkView {

    void onCallStart();

    void onCallComplete();

    void onCallError(String message);

    void redirectToSplash();
}