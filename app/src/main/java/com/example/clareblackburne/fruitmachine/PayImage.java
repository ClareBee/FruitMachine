package com.example.clareblackburne.fruitmachine;

/**
 * Created by clareblackburne on 03/11/2017.
 */

public class PayImage {

        Symbol symbol;

        public PayImage(Symbol symbol){
                this.symbol = symbol;

        }

        public Symbol getSymbol() {
                return symbol;
        }

        public void setSymbol(Symbol symbol) {
                this.symbol = symbol;
        }

        public int getValue(){
                return symbol.getValue();
        }
}
