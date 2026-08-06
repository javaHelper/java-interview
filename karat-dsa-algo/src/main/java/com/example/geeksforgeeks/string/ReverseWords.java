package com.example.geeksforgeeks.string;

import java.util.Stack;

public class ReverseWords {

    String reverseWords(String s) {
        String[] words = s.split("\\.");
        StringBuilder ans = new StringBuilder();
        boolean first = true;

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].isEmpty()) {
                continue;
            }
            if (!first) {
                ans.append(".");
            }
            ans.append(words[i]);
            first = false;
        }
        return ans.toString();
    }

    static void main() {
        ReverseWords sol = new ReverseWords();
        System.out.println(sol.reverseWords("i.like.this.program.very.much"));
        System.out.println();
    }
}
