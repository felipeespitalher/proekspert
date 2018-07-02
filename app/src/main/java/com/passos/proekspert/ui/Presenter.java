package com.passos.proekspert.ui;

import android.content.SharedPreferences;

import com.passos.proekspert.service.repository.MatchRepository;

import javax.inject.Inject;

public class Presenter implements Contract.Presenter {

    private final String SHARED_PREFERENCE_IS_PREDICTION = "Presenter.isPrediction";

    private Contract.View view;

    private final SharedPreferences sharedPreferences;
    private final MatchRepository matchRepository;

    @Inject
    public Presenter(SharedPreferences sharedPreferences, MatchRepository matchRepository) {
        this.sharedPreferences = sharedPreferences;
        this.matchRepository = matchRepository;
    }

    @Override
    public boolean isPrediction() {
        return sharedPreferences.getBoolean(SHARED_PREFERENCE_IS_PREDICTION, true);
    }

    @Override
    public void saveScreenState(boolean isPrediction) {
        sharedPreferences.edit().putBoolean(SHARED_PREFERENCE_IS_PREDICTION, isPrediction).apply();
    }

    @Override
    public void setView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void load(boolean isPrediction) {
        saveScreenState(isPrediction);
    }

    @Override
    public void load() {
//        matchRepository
    }

    @Override
    public void dispose() {
        matchRepository.dispose();
        this.view = null;
    }

}
