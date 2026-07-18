package com.example.tree.treefundamentals;

public class NumberComplement_476 {
    public int findComplement(int num) {
        // Find the number of bits in num's binary representation
        int bitLength = Integer.toBinaryString(num).length();

        // Create a mask with all 1s of that length
        int mask = (1 << bitLength) - 1;

        // XOR flips all bits within the mask's range
        return num ^ mask;
    }

    public static void main(String[] args) {
        NumberComplement_476 n = new NumberComplement_476();
        System.out.println(n.findComplement(5));
        System.out.println(n.findComplement(1));
    }
}
