package com.example.dsa.string;

import java.util.Arrays;

/**
 * Two-Pointer (Recommended)
 * Intuition: Use two pointers starting from both ends of the array and swap characters as they move toward
 * the center
 *
 * Time Complexity: O(n) – Each character is visited once
 * Space Complexity: O(1) – In-place reversal without extra memory
 *
 * Why this is best: Most efficient, meets the in-place requirement, and is the expected interview solution
 */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString_344 r = new ReverseString_344();
        // Test case 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.println("Before: " + Arrays.toString(s1));
        r.reverseString(s1);
        System.out.println("After:  " + Arrays.toString(s1));

        // Test case 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.println("\nBefore: " + Arrays.toString(s2));
        r.reverseString(s2);
        System.out.println("After:  " + Arrays.toString(s2));
    }
}
