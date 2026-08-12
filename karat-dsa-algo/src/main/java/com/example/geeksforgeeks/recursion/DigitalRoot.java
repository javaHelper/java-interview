package com.example.geeksforgeeks.recursion;

public class DigitalRoot {
    static int digitalRoot(int n) {
        // Base case
        if (n < 10) {
            return n;
        }
        int sum = 0;

        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return digitalRoot(sum);
    }

    static void main() {
        System.out.println(DigitalRoot.digitalRoot(1));
        System.out.println(DigitalRoot.digitalRoot(9999));
    }
}
