package com.passos.proekspert.service.model;

import com.google.gson.annotations.SerializedName;

public class Match {

    @SerializedName("team1")
    private String team1;

    @SerializedName("team2")
    private String team2;

    @SerializedName("team1_points")
    private int team1Points;

    @SerializedName("team2_points")
    private int team2Points;

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public int getTeam1Points() {
        return team1Points;
    }

    public void setTeam1Points(int team1Points) {
        this.team1Points = team1Points;
    }

    public int getTeam2Points() {
        return team2Points;
    }

    public void setTeam2Points(int team2Points) {
        this.team2Points = team2Points;
    }
}
