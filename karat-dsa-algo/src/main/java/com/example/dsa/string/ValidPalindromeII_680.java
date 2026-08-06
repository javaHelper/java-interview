package com.example.dsa.string;

public class ValidPalindromeII_680 {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // Mismatch found → check both deletion possibilities
                return isPalindrome(s, left + 1, right) ||
                        isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true; // Already a palindrome
    }

    // Helper method to check if substring s[left...right] is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void main() {
        ValidPalindromeII_680 sol = new ValidPalindromeII_680();
        System.out.println(sol.validPalindrome("aba"));
    }
}
