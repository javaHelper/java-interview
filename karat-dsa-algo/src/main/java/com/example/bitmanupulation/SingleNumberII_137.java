package com.example.bitmanupulation;

public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {
        int ones = 0; // Bits that have appeared 1 time (mod 3)
        int twos = 0; // Bits that have appeared 2 times (mod 3)

        for (int num : nums) {
            // If a bit is in twos, it shouldn't be added to ones.
            ones = (ones ^ num) & ~twos;
            // If a bit is in ones (after update), it shouldn't be added to twos.
            twos = (twos ^ num) & ~ones;
        }

        return ones; // Bits that appear once are the answer[reference:2]
    }

    static void main() {
        SingleNumberII_137 x = new SingleNumberII_137();
        System.out.println(x.singleNumber(new int[]{}));
    }
}
