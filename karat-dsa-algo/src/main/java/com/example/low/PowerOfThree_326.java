package com.example.low;

public class PowerOfThree_326 {
    static void main() {
        PowerOfThree_326 x = new PowerOfThree_326();
        System.out.println(x.isPowerOfThree(27));
        System.out.println(x.isPowerOfThree(11));
        System.out.println(x.isPowerOfThree(9));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
