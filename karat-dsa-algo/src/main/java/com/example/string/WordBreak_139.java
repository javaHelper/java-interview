package com.example.string;

import java.util.Arrays;
import java.util.List;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // Empty string is always valid

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break; // No need to check other words
                }
            }
        }
        return dp[n];
    }

    static void main() {
        WordBreak_139 x = new WordBreak_139();

        // Example 1: "leetcode" → true
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Input: s = \"" + s1 + "\", wordDict = " + dict1);
        System.out.println("Output: " + x.wordBreak(s1, dict1)); // true

        // Example 2: "applepenapple" → true
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Input: s = \"" + s2 + "\", wordDict = " + dict2);
        System.out.println("Output: " + x.wordBreak(s2, dict2)); // true

        // Example 3: "catsandog" → false
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Input: s = \"" + s3 + "\", wordDict = " + dict3);
        System.out.println("Output: " + x.wordBreak(s3, dict3)); // false

        // Edge case: single word match
        String s4 = "hello";
        List<String> dict4 = Arrays.asList("hello", "world");
        System.out.println("Input: s = \"" + s4 + "\", wordDict = " + dict4);
        System.out.println("Output: " + x.wordBreak(s4, dict4)); // true

        // Edge case: no match
        String s5 = "hello";
        List<String> dict5 = Arrays.asList("hell", "lo");
        System.out.println("Input: s = \"" + s5 + "\", wordDict = " + dict5);
        System.out.println("Output: " + x.wordBreak(s5, dict5)); // false
    }
}
