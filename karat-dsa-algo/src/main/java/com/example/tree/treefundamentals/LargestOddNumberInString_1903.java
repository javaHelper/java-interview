package com.example.tree.treefundamentals;

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
