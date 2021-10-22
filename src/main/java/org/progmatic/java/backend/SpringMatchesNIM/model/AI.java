package org.progmatic.java.backend.SpringMatchesNIM.model;

import org.progmatic.java.backend.SpringMatchesNIM.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AI implements Player{

    private Difficulty difficulty;

    @Autowired
    private RandomGenerator rand;

    @Override
    public int nextMove(int actual) {
        int move;

        switch (difficulty) {
            case CAUTIOUS:
                move = nextCautiousMove(actual);
                break;
            case FOOL:
                move = nextFoolMove(actual);
                break;
            case AVERAGE:
                move = nextAverageMove(actual);
                break;
            case CLEVER:
                move = nextCleverMove(actual);
                break;
            default:
                move = 0;
        }
        return move;
    }

    @Override
    public void setDifficulty(int diffValue) {
        difficulty = Difficulty.getByValue(diffValue);
    }

    private int nextCautiousMove(int actual) {
        return 1;
    }

    private int nextCleverMove(int actual) {
        int position = actual % 4;
        if (position == 0)
            position += 4;
        if (position == 1)
            return nextCautiousMove(actual);
        return position - 1;
    }

    private int nextFoolMove(int actual) {
        return Math.min(rand.getRandomInt(1, 3), actual);
    }

    private int nextAverageMove(int actual) {
        if (actual > 7)
            return nextFoolMove(actual);
        return nextCleverMove(actual);
    }
}
