package com.example.dsa.bitmanupulation;

/**
 * <h1> 1. What XOR does at the bit level </h1>
 * XOR compares two bits:
 *   If the bits are different, the result is 1.
 *   If the bits are the same, the result is 0.
 *
 * 2. The 3 Golden Properties of XOR
 * To understand the code, you need to remember these mathematical rules (they apply to integers,
 * and char in Java is treated as a 16-bit integer):
 *
 * Identity Law: a ^ 0 = a (XOR with zero does nothing).
 * Self-Inverse: a ^ a = 0 (XORing a number with itself cancels out to zero).
 *
 * Commutative & Associative: a ^ b = b ^ a and (a ^ b) ^ c = a ^ (b ^ c)
 * (Order doesn't matter, you can regroup them).
 *
 *
 * 4. Walkthrough with a Real Example
 * Let’s use s = "abc" and t = "abxc" (The extra letter is 'x').
 *
 * ASCII Values: 'a'=97, 'b'=98, 'c'=99, 'x'=120.
 * Loop 1 (s): 97 ^ 98 ^ 99
 * Loop 2 (t): 97 ^ 98 ^ 120 ^ 99
 *
 * Rearranged total:
 * (97 ^ 97) ^ (98 ^ 98) ^ (99 ^ 99) ^ 120
 * = 0 ^ 0 ^ 0 ^ 120
 * = 120 (which is the ASCII code for 'x').
 */


public class FindTheDifference_389 {
    // explicit assignment with XOR expression
    /*public char findTheDifference(String s, String t) {
        char diff = 0;
        for (char c : s.toCharArray()) {
            diff = (char) (diff ^ c);
        }
        for (char c : t.toCharArray()) {
            diff = (char) (diff ^ c);
        }
        return diff;
    }*/

    // This is compound assignment ==> result ^= c;
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheDifference_389 f = new FindTheDifference_389();
        System.out.println(f.findTheDifference("abcd", "abcde"));
        System.out.println(f.findTheDifference("", "y"));
    }
}
