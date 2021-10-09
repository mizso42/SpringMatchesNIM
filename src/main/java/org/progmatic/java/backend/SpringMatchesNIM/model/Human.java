package org.progmatic.java.backend.SpringMatchesNIM.model;

import org.progmatic.java.backend.SpringMatchesNIM.util.InputHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Human implements Player{

    @Autowired
    InputHandler scan = new InputHandler();

    @Override
    public int nextMove(int current) {
        System.out.println("There are " + current + " matches in the box. How many do you want to take?");
        int choice = scan.getInt(1, Math.min(current, 3));

        return choice;
    }

    public void setDifficulty(int diffValue) {}
}
