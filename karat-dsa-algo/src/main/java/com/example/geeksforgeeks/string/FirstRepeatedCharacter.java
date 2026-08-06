package com.example.geeksforgeeks.string;

public class FirstRepeatedCharacter {
    String firstRepChar(String s) {
        boolean[] freq = new boolean[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (freq[idx]) {
                return String.valueOf(c);
            }
            freq[idx] = true;
        }

        return "-1";
    }

    static void main() {
        FirstRepeatedCharacter sol = new FirstRepeatedCharacter();
        System.out.println(sol.firstRepChar("geeksforgeeks"));
    }
}
