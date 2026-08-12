package com.example.geeksforgeeks.recursion;

public class Factorial {
    int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    static void main() {
        Factorial f = new Factorial();
        System.out.println(f.factorial(5));
        System.out.println(f.factorial(4));
    }
}
