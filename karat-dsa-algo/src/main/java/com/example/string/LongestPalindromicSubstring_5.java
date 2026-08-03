package com.example.string;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome: center at i
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome: center between i and i+1
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length = right - left - 1
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 x = new LongestPalindromicSubstring_5();

        // Example 1: "babad" → "bab" or "aba"
        String s1 = "babad";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + x.longestPalindrome(s1));

        // Example 2: "cbbd" → "bb"
        String s2 = "cbbd";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + x.longestPalindrome(s2));

        // Example 3: "a" → "a"
        String s3 = "a";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + x.longestPalindrome(s3));

        // Example 4: "racecar" → "racecar"
        String s4 = "racecar";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + x.longestPalindrome(s4));
    }
}
