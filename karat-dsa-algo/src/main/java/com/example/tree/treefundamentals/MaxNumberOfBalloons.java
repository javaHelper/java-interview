package com.example.tree.treefundamentals;

public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for (char c : text.toCharArray()) {
            freq[c - 'a']++;
        }

        int b = freq['b' - 'a']; // 1
        int a = freq['a' - 'a']; // 0
        int l = freq['l' - 'a']; // 11
        int o = freq['o' - 'a']; // 14
        int n = freq['n' - 'a']; // 13

        int oMin = Math.min(o / 2, n);
        int lMin = Math.min(l / 2, oMin);
        int aMin = Math.min(a, lMin);
        return Math.min(b, aMin);
    }

    public static void main(String[] args) {
        MaxNumberOfBalloons solution = new MaxNumberOfBalloons();
        System.out.println(solution.maxNumberOfBalloons("nlaebolko")); // Expected: 1
        System.out.println(solution.maxNumberOfBalloons("loonbalxballpoon")); // Expected: 2
        System.out.println(solution.maxNumberOfBalloons("leetcode")); // Expected: 0
    }
}
