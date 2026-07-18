package com.example.tree.treefundamentals;

public class HammingWeight_191 {
    public static int hammingWeight(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11)); // Output: 3 (binary 1011)
        System.out.println(hammingWeight(128)); // Output: 1 (binary 10000000)
        System.out.println(hammingWeight(255)); // Output: 8 (binary 11111111)
        System.out.println(hammingWeight(0)); // Output: 0 (binary 0)
        System.out.println(hammingWeight(1)); // Output: 1 (binary 1)
        System.out.println(hammingWeight(15)); // Output: 4 (binary 1111)
        System.out.println(hammingWeight(1023)); // Output: 10 (binary 1111111111)
    }
}
