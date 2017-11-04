package com.example.clareblackburne.fruitmachine;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static com.example.clareblackburne.fruitmachine.Symbol.BANANA;
import static org.junit.Assert.assertEquals;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class TestFruitMachine {

    FruitMachine fruitMachine;
    FruitMachine spyFruitMachine;
    Player player;
    PayImage payImage;

    @Before
    public void before(){
        fruitMachine = new FruitMachine(1000, 5);
        player = new Player("Bob", 100);
        payImage = new PayImage(BANANA);
        spyFruitMachine = Mockito.spy(fruitMachine);
    }

    @Test
    public void testHasReels(){
        assertEquals(9, fruitMachine.reel1.size());
        assertEquals(9, fruitMachine.reel2.size());
    }

    @Test
    public void testCanTakeFee(){
        fruitMachine.takeMoney(player);
        assertEquals(95, player.getFunds(), 0.1);
        assertEquals(1005, fruitMachine.getFunds(), 0.1);
    }

    @Test
    public void testHasSpunReel(){
        assertEquals(3, fruitMachine.spunreel.size());
    }

    @Test
    public void testCanSpinOneReel(){
        Mockito.when(spyFruitMachine.spinReel1()).thenReturn(new PayImage(Symbol.BANANA));
        PayImage payimage = spyFruitMachine.spinReel1();
        assertEquals(BANANA, payimage.getSymbol());
    }


    @Test
    public void testWinnings(){
        fruitMachine.setCheckWin(true);
        fruitMachine.returnWinningsToPlayer(player);
        boolean result = fruitMachine.getFunds() < 1000;
        assert(result);
    }

    @Test
    public void testPlayerGetsWinnings(){
        fruitMachine.setCheckWin(true);
        fruitMachine.returnWinningsToPlayer(player);
        boolean result = player.getFunds() > 100;
        assert(result);
    }

    @Test
    public void testCanWin(){
        Mockito.when(spyFruitMachine.spinReel1()).thenReturn(new PayImage(Symbol.BANANA));
        Mockito.when(spyFruitMachine.spinReel2()).thenReturn(new PayImage(Symbol.BANANA));
        Mockito.when(spyFruitMachine.spinReel3()).thenReturn(new PayImage(Symbol.BANANA));
        PayImage pay1 = spyFruitMachine.spinReel1();
        PayImage pay2 = spyFruitMachine.spinReel2();
        PayImage pay3 = spyFruitMachine.spinReel3();
        spyFruitMachine.spunreel.add(0, pay1);
        spyFruitMachine.spunreel.add(1, pay2);
        spyFruitMachine.spunreel.add(2, pay3);
        spyFruitMachine.checkIfWon();
        spyFruitMachine.returnWinningsToPlayer(player);
        assertEquals(true, spyFruitMachine.checkWin);
        assertEquals(970.0, spyFruitMachine.getFunds(), 0.1);
        assertEquals(130, player.getFunds(), 0.1);
    }

//    @Test
//    public void canHoldOneSpinTwo(){
//
//    }

}
