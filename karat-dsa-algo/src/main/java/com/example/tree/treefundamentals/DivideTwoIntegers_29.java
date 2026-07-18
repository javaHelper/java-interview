package com.example.tree.treefundamentals;

import java.math.BigDecimal;

public class DivideTwoIntegers_29 {
    public int divide(int dividend, int divisor){
        BigDecimal bd1 = new BigDecimal(dividend);
        BigDecimal bd2 = new BigDecimal(divisor);
        return bd1.divide(bd2).intValue();
    }

    public static void main(String[] args) {
        DivideTwoIntegers_29 x = new DivideTwoIntegers_29();
        System.out.println(x.divide(10, 3)); // Output: 3
    }
}
