package com.example.clareblackburne.fruitmachine;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public enum Symbol {

        CHERRY(10),
        APPLE(15),
        ORANGE(40),
        PEAR(5),
        BELL(20),
        BANANA(30),
        LEMON(50),
        BAR(100),
        BIGWIN(1000);

    public int value;

    Symbol(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }



}
