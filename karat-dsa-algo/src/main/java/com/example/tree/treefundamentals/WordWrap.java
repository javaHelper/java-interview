package com.example.tree.treefundamentals;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {
    public static void main(String[] args) {
        String[] words1 = {
                "The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant",
                "flame"
        };

        System.out.println(wrapLines(words1, 13));
        System.out.println(wrapLines(words1, 12));
    }

    private static List<String> wrapLines(String[] words, int maxLen) {
        List<String> res = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            if (builder.length() == 0) {
                builder.append(word);
            } else {
                int potentialLen = word.length() + 1 + builder.length();
                if (potentialLen <= maxLen) {
                    builder.append("-").append(word);
                } else {
                    res.add(builder.toString());
                    builder = new StringBuilder(word);
                }
            }
        }
        return res;
    }
}