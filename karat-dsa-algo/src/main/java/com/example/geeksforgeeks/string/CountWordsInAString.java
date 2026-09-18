package com.example.geeksforgeeks.string;

/*
Given a string s consisting of lowercase English alphabets, spaces, tab characters (\t),
and newline characters (\n), count the total number of words present in the string.

A word is defined as a continuous sequence of lowercase English letters, while spaces, tabs,
 ̰and newline characters act as separators between words.
 */


public class CountWordsInAString {

    /*
    It counts the number of words in a string, where a word is defined as a contiguous
    sequence of lowercase English letters (a–z). Any character outside that range (spaces, digits,
    punctuation, uppercase letters, etc.) acts as a delimiter (word separator).
 */
    public int countWords(String s) {
        int count = 0;
        boolean inWord = false;

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return count;
    }

    static void main() {
        CountWordsInAString x = new CountWordsInAString();
        System.out.println(x.countWords("abc def"));
        System.out.println(x.countWords("a\nyo\t"));
    }
}



