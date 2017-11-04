package com.example.clareblackburne.fruitmachine;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class FruitMachine {

    private double funds;
    private ArrayList<Image> reel1;
    private ArrayList<Image> reel2;
    private ArrayList<Image> reel3;
    private ArrayList<Image> spunreel;
    private double cost;
    private double spinCost;

    private Random randomImage;
    private boolean checkWin;
    private Image chosen;



    public FruitMachine(double funds, double cost){
        this.funds = funds;
        this.reel1 = new ArrayList<Image>();
        this.reel2 = new ArrayList<Image>();
        this.reel3 = new ArrayList<Image>();
        this.spunreel = new ArrayList<Image>();
        this.cost = cost;
        generateReel1();
        generateReel2();
        generateReel3();
        setUpSpunReel();
        randomImage = new Random();
        this.checkWin = false;
        this.spinCost = this.cost / 10;
    }


    public double getCost() {
        return cost;
    }

    public void setCheckWin(boolean checkWin) {
        this.checkWin = checkWin;
    }

    public boolean isCheckWin() {
        return checkWin;
    }

    public ArrayList<Image> getSpunreel() {
        return spunreel;
    }

    public double getFunds() {
        return funds;
    }

    public ArrayList<Image> getReel1() {
        return reel1;
    }

    public void setFunds(double funds) {
        this.funds = funds;
    }

    public double getSpinCost(){
        return this.spinCost;
    }


    public void generateReel1(){
        for(Symbol symbol : Symbol.values())
        reel1.add(new Image(symbol));
    }

    public void generateReel2(){
        for(Symbol symbol : Symbol.values())
            reel2.add(new Image(symbol));
    }

    public void generateReel3(){
        for(Symbol symbol : Symbol.values())
            reel3.add(new Image(symbol));
    }

    public void setUpSpunReel(){
        spunreel.add(0, new Image(Symbol.APPLE));
        spunreel.add(1, new Image(Symbol.BAR));
        spunreel.add(2, new Image(Symbol.BELL));
    }


    public void takeMoney(Player player){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        if(player.getFunds() > 0) {
            player.setFunds(player.getFunds() - this.cost);
            this.funds += this.cost;
            System.out.println("You now have " + formatter.format(player.getFunds()));
        } else {
            System.out.println("Sorry, game over, you've run out of cash!");
            System.exit(0);
        }
    }


    public void returnWinningsToPlayer(Player player) {
        if (checkWin) {
            double winnings = spunreel.get(0).symbol.getValue();
            if(this.funds > winnings) {
                player.setFunds(player.getFunds() + winnings);
                this.funds -= winnings;
            } else {
                System.out.println("Go to the bar. This machine is out of cash!");
            }
        }
    }


    public void spin(Player player){
        spinReel1();
        spinReel2();
        spinReel3();
        takeMoney(player);
        checkIfWon();
    }


    public Image spinReel1(){

        int index = randomImage.nextInt(reel1.size());
        chosen = reel1.get(index);
        spunreel.set(0, new Image(chosen.getSymbol()));
        return spunreel.get(0);
    }

    public Image spinReel2(){
        int index = randomImage.nextInt(reel2.size());
        chosen = reel2.get(index);
        spunreel.set(1, new Image(chosen.getSymbol()));
        return spunreel.get(1);
    }

    public Image spinReel3(){
        int index = randomImage.nextInt(reel3.size());
        chosen = reel3.get(index);
        spunreel.set(2, new Image(chosen.getSymbol()));
        return spunreel.get(2);
    }

    public void holdOneReelSpinTwo(int reelChannel){
        if(reelChannel == 1){
            spinReel2();
            spinReel3();
        }
        else if(reelChannel == 2){
            spinReel1();
            spinReel3();


        } else{
            spinReel1();
            spinReel2();
        }
        checkIfWon();
    }


    public void checkIfWon() {

        if (spunreel.get(0).getSymbol().equals(spunreel.get(1).getSymbol()) && (spunreel.get(0).getSymbol().equals(spunreel.get(2).getSymbol())) ){
            this.setCheckWin(true);
            returnResults();
            System.out.println("Congratulations, you've won!");
            }
         else {
            this.setCheckWin(false);
            returnResults();
            System.out.println("Press a to spin all three, or press b to choose whether to stick with one or two of the images!");
            }
    }

    public void returnResults(){
        ArrayList<Image> results = new ArrayList<>();
        for(Image image : spunreel){
            results.add(image);
        }
        System.out.println("You've just spun " + results.get(0).getSymbol() + ", " + results.get(1).getSymbol() + ", " + results.get(2).getSymbol());
    }



}

