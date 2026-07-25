package com.example.array;

public class PalindromeNumber_9 {
    public static boolean isPalindrome(int x) {
        // Negative numbers are never palindromes
        if (x < 0) {
            return false;
        }

        int original = x;
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }

        return original == reversed;
    }

    public static boolean isPalindrome1(int x) {
        // Negative numbers are never palindromes
        if (x < 0) {
            return false;
        }
        String str = Integer.toString(x);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));

        System.out.println("------------------------");
        System.out.println(isPalindrome1(121));
        System.out.println(isPalindrome1(-121));
        System.out.println(isPalindrome1(10));
    }
}
