package com.example.geeksforgeeks.string;

public class PanagramChecking {
    public static boolean checkPangram(String s) {
        boolean[] seen = new boolean[26];

        for (char ch : s.toCharArray()) {
            ch = Character.toLowerCase(ch);
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
