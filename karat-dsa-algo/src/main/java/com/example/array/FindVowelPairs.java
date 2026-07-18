package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class FindVowelPairs {
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static List<String> getVowelPairs(String str) {
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (isVowel(str.charAt(i)) && isVowel(str.charAt(i + 1))) {
                pairs.add("" + str.charAt(i) + str.charAt(i + 1));
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(getVowelPairs("abaebio"));
    }
}
