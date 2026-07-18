package com.example.low;

public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        long upper = word.chars().filter(Character::isUpperCase).count();
        return upper == 0 || upper == word.length() ||
                (upper == 1 && Character.isUpperCase(word.charAt(0)));
    }

    public static void main(String[] args) {
        DetectCapital_520 d = new DetectCapital_520();
        System.out.println(d.detectCapitalUse("USA"));
        System.out.println(d.detectCapitalUse("FlaG"));
    }
}
