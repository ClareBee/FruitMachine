package com.example.clareblackburne.fruitmachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class TestPayImage {


    PayImage payimage;

    @Before
    public void before(){
        payimage = new PayImage(Symbol.BANANA);
    }

    @Test
    public void testImageHasValue(){
        assertEquals(30, payimage.getSymbol().getValue());
    }
}
