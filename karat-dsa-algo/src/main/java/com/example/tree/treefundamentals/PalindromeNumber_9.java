package com.example.tree.treefundamentals;

public class PalindromeNumber_9 {
    public static boolean isPalindrome(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int lastDigit = reverseNum % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            num = num / 10;
        }
        return num == reverseNum;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1111111));
    }
}
