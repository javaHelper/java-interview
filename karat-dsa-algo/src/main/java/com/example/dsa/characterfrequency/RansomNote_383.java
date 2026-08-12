package com.example.dsa.characterfrequency;

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote_383 ransomNote = new RansomNote_383();
        System.out.println(ransomNote.canConstruct("aa", "aab"));
        System.out.println(ransomNote.canConstruct("aa", "ab"));
        System.out.println(ransomNote.canConstruct("a", "b"));
        System.out.println(ransomNote.canConstruct("aa", "aab"));
    }
}
