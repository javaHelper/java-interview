package com.example.geeksforgeeks.string;

public class PanagramChecking {
    /**
     * A "Panagram" is a sentence containing every letter in the English Alphabet
     * either in lowercase or Uppercase.
     */
    public static boolean checkPangram(String s) {
        s = s.toLowerCase();
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                seen[ch - 'a'] = true;
            }
        }
        for (boolean present : seen) {
            if (!present) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println(PanagramChecking.checkPangram("Bawds jog, flick quartz, vex nymph"));
        System.out.println(PanagramChecking.checkPangram("sdfs"));
    }
}
