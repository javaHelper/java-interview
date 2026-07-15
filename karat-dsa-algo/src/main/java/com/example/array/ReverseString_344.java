package com.example.array;

import java.util.Arrays;

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
