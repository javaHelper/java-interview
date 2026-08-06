package com.example.geeksforgeeks;

public class PalindromeString {
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void main() {
        PalindromeString p = new PalindromeString();
        System.out.println(p.isPalindrome("abba"));
        System.out.println(p.isPalindrome("abc"));
    }
}
