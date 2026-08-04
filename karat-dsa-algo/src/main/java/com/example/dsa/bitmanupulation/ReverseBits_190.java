package com.example.dsa.bitmanupulation;

public class ReverseBits_190 {
    public int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n
            int bit = n & 1;

            // Shift result left and add the extracted bit
            res = (res << 1) | bit;

            // Shift n right to process the next bit
            n = n >>> 1;  // Use unsigned right shift
        }
        return res;
    }

    static void main() {
        ReverseBits_190 r = new ReverseBits_190();
        System.out.println(r.reverseBits(00000000000000000000000000010101));
    }
}
