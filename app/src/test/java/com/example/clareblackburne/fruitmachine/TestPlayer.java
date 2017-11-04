package com.example.clareblackburne.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class TestPlayer {

    Player player;
    FruitMachine fruitmachine;

    @Before
    public void before(){
        player = new Player("Bob", 10);
        fruitmachine = new FruitMachine(1000, 5);
    }


    @Test
    public void testFundsDecrease(){
        fruitmachine.spin(player);
        assertEquals(5, player.getFunds(), 0.1);
    }

    //    @Test
//    public void testCantPlayWithZero(){
//        fruitmachine.spin(player);
//    }


}
