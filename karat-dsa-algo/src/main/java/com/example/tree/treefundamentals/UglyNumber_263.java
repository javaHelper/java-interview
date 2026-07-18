package com.example.tree.treefundamentals;

public class UglyNumber_263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n = n / factor;
            }
        }
        // If the remaining number is 1, it's an ugly number
        return n == 1;
    }

    /*public boolean isUgly(int n) {
        if (n <= 0)
            return false;

        while (n % 2 == 0) {
            n = n / 2;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }

        while (n % 5 == 0) {
            n = n / 5;
        }
        // If the remaining number is 1, it's an ugly number
        return n == 1;
    }*/

    public static void main(String[] args) {
        UglyNumber_263 x = new UglyNumber_263();
        System.out.println(x.isUgly(6));
        System.out.println(x.isUgly(1));
        System.out.println(x.isUgly(14));
        System.out.println(x.isUgly(30));
    }
}
