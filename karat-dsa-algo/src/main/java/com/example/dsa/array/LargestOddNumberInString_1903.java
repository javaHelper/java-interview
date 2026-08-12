package com.example.dsa.array;


/**
 *1. The Trick: Subtracting '0'
 * In Java (and C/C++), characters are stored as integer numbers based on the ASCII/Unicode table.
 *
 * The character '0' has a numeric value of 48.
 * The character '1' has a numeric value of 49.
 * The character '2' has a value of 50.
 * ...
 * ...
 * The character '9' has a value of 57.
 */

public class LargestOddNumberInString_1903 {

    public static void main(String[] args) {
        LargestOddNumberInString_1903 x = new LargestOddNumberInString_1903();
        System.out.println(x.largestOddNumber("52"));
        System.out.println(x.largestOddNumber("4206"));
        System.out.println(x.largestOddNumber("35427"));
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = num.charAt(i) - '0';
            if (digit % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
