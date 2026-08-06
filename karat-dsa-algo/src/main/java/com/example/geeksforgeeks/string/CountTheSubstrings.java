package com.example.geeksforgeeks.string;

import java.util.HashMap;
import java.util.Map;

public class CountTheSubstrings {
    int countSubstring(String S) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int balance = 0;
        int ans = 0;

        for (char c : S.toCharArray()) {
            if (Character.isUpperCase(c)) {
                balance++;
            } else {
                balance--;
            }
            ans = ans + freq.getOrDefault(balance, 0);

            freq.put(balance, freq.getOrDefault(balance, 0) + 1);
        }
        return ans;
    }

    static void main() {
        CountTheSubstrings sol = new CountTheSubstrings();
        System.out.println(sol.countSubstring("gEEk"));
        System.out.println(sol.countSubstring("WomensDAY"));
    }
}
