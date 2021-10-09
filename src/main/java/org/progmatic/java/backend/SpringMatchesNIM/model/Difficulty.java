package org.progmatic.java.backend.SpringMatchesNIM.model;

public enum Difficulty {
    CAUTIOUS(0),
    FOOL(1),
    AVERAGE(2),
    CLEVER(3);

    public final int value;

    Difficulty(int value) {
        this.value = value;
    }

    public static Difficulty getByValue(int value) {
        int i = 0;
        while (values()[i].value != value) {
            i++;
        }
        return values()[i];
    }
}
