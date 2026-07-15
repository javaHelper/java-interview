package com.example.array;

public class PowerOfFour_342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;

        while (n % 4 == 0) {
            n /= 4;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        PowerOfFour_342 p = new PowerOfFour_342();
        System.out.println(p.isPowerOfFour(16));
        System.out.println(p.isPowerOfFour(5));
        System.out.println(p.isPowerOfFour(1));
    }
}
