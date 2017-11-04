package com.example.clareblackburne.fruitmachine;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class ConsoleLogger {

    public static void main(String[] args) {

        FruitMachine fruitmachine = new FruitMachine(1000, 5);
        Player player = new Player("", 0);
        NumberFormat format = NumberFormat.getCurrencyInstance();


        System.out.println("Welcome to the Fruitmachine");

        System.out.println("What's your name?");
        String name = "";
        Scanner scan = new Scanner(System.in);
        player.setName(scan.nextLine());
        System.out.println("Hello, " + player.getName() + ". How much money do you have?");
        player.setFunds(scan.nextDouble());

        System.out.println("This fruitmachine costs " + format.format(fruitmachine.getCost()) + " every time you spin all three reels. After the first spin, you can choose to spin just one of the reels, or hold one and spin the other two!");

        System.out.println("Press any letter to see how much you could win!");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        for (Image image : fruitmachine.getReel1()) {
            System.out.println(image.getSymbol() + " = " + format.format(image.getSymbol().getValue()));
        }

            System.out.println("(Press any letter to continue)");
            scanner.nextLine();

            System.out.println("Right, " + player.getName() + ", let's spin!");
            System.out.println("Spinnnnnning");
            fruitmachine.spin(player);
            System.out.println("You now have " + format.format(player.getFunds()));


            String answer = "";
            do {
                Scanner scan2 = new Scanner(System.in);
                answer = scan2.nextLine();

                if (answer.contains("a")) {
                    fruitmachine.spin(player);
                    System.out.println("You now have " + format.format(player.getFunds()));

                } else if (answer.contains("b")) {
                    System.out.println("Press a to spin a single reel or b to spin two reels");

                    String answer2 = "";
                    answer2 = scan2.nextLine();

                    if (answer2.contains("a")) {
                        System.out.println("Choose which reel to spin: 1, 2 or 3");
                        int answer3 = scan.nextInt();

                        if (answer3 == 1) {
                            fruitmachine.spinReel1();
                            fruitmachine.checkIfWon();
                        } else if (answer3 == 2) {
                            fruitmachine.spinReel2();
                            fruitmachine.checkIfWon();
                        } else {
                            fruitmachine.spinReel3();
                            fruitmachine.checkIfWon();
                        }

                    } else {
                        System.out.println("Choose which reel to stick with - 1, 2 or 3 - and spin the others");
                        Scanner scanner2 = new Scanner(System.in);
                        fruitmachine.holdOneReelSpinTwo(scanner2.nextInt());
                    }
                }
            }
            while (!fruitmachine.isCheckWin());
            fruitmachine.returnWinningsToPlayer(player);
            System.out.println("You've won " + format.format(fruitmachine.getSpunreel().get(0).symbol.getValue()));
            System.out.println("You've now got " + format.format(player.getFunds()));

        }
}



