package com.example.geeksforgeeks.string;

import java.util.Arrays;

public class StringDuplicatesRemoval {
    public String removeDuplicates(String s) {
        boolean[] seen = new boolean[256]; // covers all ASCII characters
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!seen[c]) {
                seen[c] = true;
                result.append(c);
            }
        }
        return result.toString();
    }

    static void main() {
        StringDuplicatesRemoval r = new StringDuplicatesRemoval();
        System.out.println(r.removeDuplicates("geEksforGEeks"));
    }
}
