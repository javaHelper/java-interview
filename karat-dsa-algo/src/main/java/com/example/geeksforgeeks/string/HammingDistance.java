package com.example.geeksforgeeks.string;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while (xor != 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }

    static void main() {
        HammingDistance h = new HammingDistance();
        System.out.println(h.hammingDistance(1,4));
    }
}
