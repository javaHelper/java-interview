package com.example.geeksforgeeks.recursion;

public class FirstNFibonacciUsingRecursion {

    public static int[] fibonacciNumbers(int n) {
        // Handle the base case for n = 1
        if (n == 1) {
            return new int[]{0};
        }

        // Create array to store the Fibonacci sequence
        int[] fib = new int[n];

        // Initialize the first two numbers
        fib[0] = 0;
        fib[1] = 1;

        // Generate the rest of the sequence
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib;
    }


    static void main() {
        int[] testInputs = {1, 2, 5, 7, 10};

        for (int n : testInputs) {
            int[] result = FirstNFibonacciUsingRecursion.fibonacciNumbers(n);
            System.out.print("First " + n + " Fibonacci numbers: ");
            for (long num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
