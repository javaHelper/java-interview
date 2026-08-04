package com.example.dsa.geeksforgeeks;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n){
        // n > 0 ensures positive numbers only (0 is not a power of two)
        // (n & (n - 1)) == 0 checks if there's exactly one set bit
        return n > 0 && (n & (n-1)) == 0;
    }

    static void main() {
        IsPowerOfTwo sol = new IsPowerOfTwo();
        System.out.println(sol.isPowerOfTwo(12));
    }
}
