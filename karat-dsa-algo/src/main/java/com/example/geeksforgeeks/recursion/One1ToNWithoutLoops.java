package com.example.geeksforgeeks.recursion;

public class One1ToNWithoutLoops {
    public void printTillN(int n) {
        // Base case: stop when n becomes 0
        if (n == 0) {
            return;
        }
        // Recursive call to print numbers up to n-1
        printTillN(n - 1);
        // After the recursive call returns, print the current number
        System.out.print(n + " ");
    }

    static void main() {
        One1ToNWithoutLoops x = new One1ToNWithoutLoops();
        x.printTillN(5);
        System.out.println();
        x.printTillN(10);
    }
}
