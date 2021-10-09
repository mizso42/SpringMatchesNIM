package org.progmatic.java.backend.SpringMatchesNIM.util;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InputHandler {
    Scanner scan = new Scanner(System.in);

    public int getInt() {
        return getInt(Integer.MAX_VALUE);
    }

    public int getInt(int max) {
        return getInt(0, max);
    }

    public int getInt(int min, int max) {
        int input;
        boolean isOutOfBound;

        do {
            input = scan.nextInt();
            scan.nextLine();
            isOutOfBound = input < min || input > max;
            if (isOutOfBound) {
                System.out.println("Input is out of bound!");
            }
        } while (isOutOfBound);

        return input;
    }
}
