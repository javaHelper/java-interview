package com.example.geeksforgeeks.string;

public class CountWordsInAString {

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
