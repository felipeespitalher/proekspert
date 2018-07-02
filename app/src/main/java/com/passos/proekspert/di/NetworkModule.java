package com.passos.proekspert.di;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.passos.proekspert.BuildConfig;
import com.passos.proekspert.service.API;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @NonNull
    @Provides
    Gson providesGson() {
        return new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
    }

    @NonNull
    @Provides
    @Reusable
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.HEADERS);
    }

    @NonNull
    @Provides
    @Reusable
    OkHttpClient providesOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(BuildConfig.NETWORK_TIME_OUT, TimeUnit.SECONDS)
                .build();
    }

    @NonNull
    @Provides
    @Reusable
    Retrofit providesRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BuildConfig.API_BASE_URL)
                .client(okHttpClient)
                .build();
    }

    @NonNull
    @Provides
    @Reusable
    API providesAPI(Retrofit retrofit) {
        return retrofit.create(API.class);
    }

}
