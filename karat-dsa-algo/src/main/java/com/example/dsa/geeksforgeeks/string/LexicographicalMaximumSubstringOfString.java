package com.example.dsa.geeksforgeeks.string;

public class LexicographicalMaximumSubstringOfString {

    public String lexicographicalMaxString(String s) {
        // Step 1: Find the largest character
        char maxChar = 'a';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > maxChar) {
                maxChar = s.charAt(i);
            }
        }

        // Step 2: Compare only suffixes starting with maxChar
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == maxChar) {
                String suffix = s.substring(i);
                if (suffix.compareTo(ans) > 0) {
                    ans = suffix;
                }
            }
        }
        return ans;
    }
}
