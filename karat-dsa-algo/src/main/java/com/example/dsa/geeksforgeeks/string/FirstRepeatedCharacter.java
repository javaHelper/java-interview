package com.example.dsa.geeksforgeeks.string;

public class FirstRepeatedCharacter {
    String firstRepChar(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx]) {
                return String.valueOf(c);
            }
            seen[idx] = true;
        }

        return "-1";
    }

    static void main() {
        FirstRepeatedCharacter sol = new FirstRepeatedCharacter();
        System.out.println(sol.firstRepChar("geeksforgeeks"));
    }
}
