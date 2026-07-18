package com.example.array;

import java.math.BigDecimal;

public class SumTwoIntegers {
    public int getSum(int a, int b) {
        BigDecimal bd1 = new BigDecimal(a);
        BigDecimal bd2 = new BigDecimal(b);
        return bd1.add(bd2).intValue();
    }

    public static void main(String[] args) {
        SumTwoIntegers solution = new SumTwoIntegers();
        System.out.println(solution.getSum(1, 2)); // Output: 3
        System.out.println(solution.getSum(2, 3)); // Output: 5
    }
}
