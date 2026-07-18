package com.example.tree.treefundamentals;

public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;

        // 1. Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Count the last word
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord_58 x = new LengthOfLastWord_58();
        System.out.println(x.lengthOfLastWord("Hello World")); // Output: 5
        System.out.println(x.lengthOfLastWord("   fly me   to   the moon  ")); // Output: 4
        System.out.println(x.lengthOfLastWord("leetcode")); // Output: 8
        System.out.println(x.lengthOfLastWord("a ")); // Output: 1
        System.out.println(x.lengthOfLastWord("   ")); // Output: 0
    }
}
