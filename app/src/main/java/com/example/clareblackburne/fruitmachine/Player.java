package com.example.clareblackburne.fruitmachine;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class Player {

    private String name;
    private double funds;
    private FruitMachine fruitmachine;

    public Player(String name, double funds){
        this.name = name;
        this.funds = funds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFunds() {
        return funds;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }


}
