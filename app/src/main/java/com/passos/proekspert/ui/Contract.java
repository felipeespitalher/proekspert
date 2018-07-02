package com.passos.proekspert.ui;

import com.passos.proekspert.service.model.Match;

import java.util.List;

public interface Contract {

    interface View {

        void onLoad(List<Match> matches);

        void onCallStart();

        void onCallComplete();

        void onCallError(String message);

    }

    interface Presenter {

        boolean isPrediction();

        void saveScreenState(boolean isPrediction);

        void setView(View view);

        void dispose();

        void load();

        void load(boolean isPrediction);
    }

}
