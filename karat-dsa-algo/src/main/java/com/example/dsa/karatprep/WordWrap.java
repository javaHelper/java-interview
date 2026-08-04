package com.example.dsa.karatprep;

import java.util.ArrayList;
import java.util.List;

public class WordWrap {

    public List<String> wrapLines(String[] words, int maxLen) {
        List<String> res = new ArrayList<>();

        StringBuilder builder = new StringBuilder();

        for (String word : words) {
            if (builder.isEmpty()) {
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

    public static void main(String[] args) {
        String[] words1 = {
                "The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant",
                "flame"
        };
        WordWrap w = new WordWrap();
        System.out.println(w.wrapLines(words1, 13));
        System.out.println(w.wrapLines(words1, 12));
    }
}