package com.passos.proekspert.service;


import com.passos.proekspert.service.model.MatchWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("5b39b317310000e50c57962b")
    Call<MatchWrapper> getMatches();

    @GET("5b39b345310000ca0c57962c")
    Call<MatchWrapper> getResults();

}
