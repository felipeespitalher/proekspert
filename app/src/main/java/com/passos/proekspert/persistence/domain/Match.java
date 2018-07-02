package com.passos.proekspert.persistence.domain;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Match {

    @PrimaryKey
    private long id;

    @Embedded(prefix = "team1_")
    private Team team1;

    @Embedded(prefix = "team2_")
    private Team teams2;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeams2() {
        return teams2;
    }

    public void setTeams2(Team teams2) {
        this.teams2 = teams2;
    }
}
