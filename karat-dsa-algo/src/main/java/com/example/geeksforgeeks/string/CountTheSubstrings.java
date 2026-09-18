package com.example.geeksforgeeks.string;

import java.util.HashMap;
import java.util.Map;

/*
    Given a string S. The task is to count the number of substrings which contains equal
    number of lowercase and uppercase letters.
 */

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
            Integer val = freq.getOrDefault(balance, 0);
            ans = ans + val;
            freq.put(balance, val + 1);
        }
        return ans;
    }

    static void main() {
        CountTheSubstrings sol = new CountTheSubstrings();
        System.out.println(sol.countSubstring("gEEk"));
        System.out.println(sol.countSubstring("WomensDAY"));
    }
}
