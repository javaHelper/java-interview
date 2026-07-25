package com.example.array;

public class AddDigits_258 {

    /**
     * Digital Root formulae
     *
     * Any number n can be written as:
     * n = a0 + a1 * 10 + a2 * 100 + .....
     *   = a0 + a1 * (9+1) + a2 * (99 + 1)+ ....
     *   = (a0 + a1 + a2+ ...) + 9* (a1 + 11 * a2 + ...)
     *
     *   so n = (sum of digits) mod 9.
     *   Repeatedly summing digits preserves this mod 9 value. The only exception is multiple pf 9
     *   (which would give you 0, but digital route is 9), and 0 itself
     *
     *   Ex: num = 38
     *   (38 - 1) % 9 = 37 % 9 = 1
     *   1 + 1 = 2
     *
     *   Ex: num = 18
     *   (18 - 1) % 9 = 8
     *   1 + 8 = 9 (because 1 + 8, single digit)
     */
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        AddDigits_258 x = new AddDigits_258();
        System.out.println(x.addDigits(38)); // Output: 2
        System.out.println(x.addDigits(8989)); // Output: 1
    }
}
