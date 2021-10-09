package org.progmatic.java.backend.SpringMatchesNIM.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGenerator {
    Random rand = new Random();

    public int getRandomInt(int min, int max) {
        return min + rand.nextInt(max + 1 - min);
    }
}
