package com.passos.proekspert.persistence.domain;

import android.arch.persistence.room.Entity;

@Entity
public class Team {

    private String name;

    private int score;

    private int prediction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPrediction() {
        return prediction;
    }

    public void setPrediction(int prediction) {
        this.prediction = prediction;
    }

}
