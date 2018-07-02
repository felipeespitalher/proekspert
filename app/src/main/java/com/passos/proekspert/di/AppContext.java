package com.passos.proekspert.di;

public class AppContext {

    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    public static void setComponent(AppComponent component) {
        AppContext.component = component;
    }

}