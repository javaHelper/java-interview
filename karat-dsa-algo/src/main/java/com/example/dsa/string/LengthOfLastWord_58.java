package com.example.dsa.string;

public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        //  we start from the end. The last word is physically located
        // at the end of the string, so working backward is the most direct path to the answer.
        int length = s.length() - 1;

        // 1. Skip trailing spaces
        while (length >= 0 && s.charAt(length) == ' ') {
            length--;
        }

        // 2. Count the last word
        int lastWordLength = 0;
        while (length >= 0 && s.charAt(length) != ' ') {
            lastWordLength++;
            length--;
        }
        return lastWordLength;
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
