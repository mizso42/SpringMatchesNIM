package org.progmatic.java.backend.SpringMatchesNIM.model;

import org.springframework.stereotype.Component;

@Component
public interface Player {

    int nextMove(int current);
    void setDifficulty(int diffValue);
}
