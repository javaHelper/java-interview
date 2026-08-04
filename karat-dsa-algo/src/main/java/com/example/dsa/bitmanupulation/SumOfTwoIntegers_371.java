package com.example.dsa.bitmanupulation;

public class SumOfTwoIntegers_371 {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;

        return getSum(a ^ b, (a & b) << 1);
    }

    static void main() {
        SumOfTwoIntegers_371 x = new SumOfTwoIntegers_371();
        System.out.println(x.getSum(1100,3000));
    }
}
