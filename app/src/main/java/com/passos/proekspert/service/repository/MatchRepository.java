package com.passos.proekspert.service.repository;


import com.passos.proekspert.persistence.dao.MatchDao;
import com.passos.proekspert.persistence.domain.Match;
import com.passos.proekspert.service.API;

import java.util.List;

import javax.inject.Inject;

public class MatchRepository extends BaseRepository {

    private final API api;
    private final MatchDao matchDao;

    @Inject
    public MatchRepository(API api, MatchDao matchDao) {
        this.api = api;
        this.matchDao = matchDao;
    }


    private List<Match> findMatches() {
        return null;
    }

}
