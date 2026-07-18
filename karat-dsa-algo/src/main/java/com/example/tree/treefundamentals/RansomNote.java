package com.example.tree.treefundamentals;

public class RansomNote {
    public boolean ransomNote(String ransomNote, String magazine) {
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
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.ransomNote("aa", "aab"));
        System.out.println(ransomNote.ransomNote("aa", "ab"));
        System.out.println(ransomNote.ransomNote("a", "b"));
        System.out.println(ransomNote.ransomNote("aa", "aab"));
    }
}
