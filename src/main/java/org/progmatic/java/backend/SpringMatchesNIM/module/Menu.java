package org.progmatic.java.backend.SpringMatchesNIM.module;

import lombok.Getter;
import org.progmatic.java.backend.SpringMatchesNIM.model.AI;
import org.progmatic.java.backend.SpringMatchesNIM.model.Difficulty;
import org.progmatic.java.backend.SpringMatchesNIM.model.Human;
import org.progmatic.java.backend.SpringMatchesNIM.model.Player;
import org.progmatic.java.backend.SpringMatchesNIM.util.InputHandler;
import org.progmatic.java.backend.SpringMatchesNIM.util.RandomGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Menu {

    @Getter
    private Player player1;

    @Getter
    private Player player2;

    int startingMatches;

    @Autowired
    RandomGenerator rand = new RandomGenerator();
    @Autowired
    InputHandler input = new InputHandler();

    public void setup() {
        startingMatches = rand.getRandomInt(4, 40);
        System.out.println("There are " + " matches in the box.\n");

        player1 = ready(player1, 1);
        player2 = ready(player2, 2);

    }

    private Player ready(Player player, int i) {

        System.out.println((i < 2 ? "First" : "Second") + " player's type:\n0 - Human\n1 - AI");
        switch (input.getInt(0, 1)) {
            case 0:
                player = new Human();
                break;
            case 1:
                player = new AI();

                System.out.println("Set AI difficulty:\n" +
                        "0 - " + Difficulty.getByValue(0).name() + "\n" +
                        "1 - " + Difficulty.getByValue(1).name() + "\n" +
                        "2 - " + Difficulty.getByValue(2).name() + "\n" +
                        "3 - " + Difficulty.getByValue(3).name());
                int diffValue = input.getInt(0, Difficulty.values().length);

                player.setDifficulty(diffValue);

                break;
        }
        return player;
    }
}
