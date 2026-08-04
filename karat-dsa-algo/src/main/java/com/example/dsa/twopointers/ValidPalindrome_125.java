package com.example.dsa.twopointers;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;

            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome_125 v = new ValidPalindrome_125();
        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(v.isPalindrome("race a car"));
        System.out.println(v.isPalindrome(" "));
    }
}
