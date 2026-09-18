package com.example.geeksforgeeks.string;

public class CatAndHat {
    public boolean catHat(String s) {
        int catCount = 0;
        int hatCount = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.charAt(i) == 'c' && s.charAt(i + 1) == 'a' && s.charAt(i + 2) == 't') {
                catCount++;
            } else if (s.charAt(i) == 'h' && s.charAt(i + 1) == 'a' && s.charAt(i + 2) == 't') {
                hatCount++;
            }
        }
        return catCount == hatCount;
    }

    public boolean catHat1(String s) {
        int catCount = 0;
        int hatCount = 0;

        for (int i = 0; i <= s.length() - 3; i++) {
            if (s.startsWith("cat", i)) {
                catCount++;
            } else if (s.startsWith("hat", i)) {
                hatCount++;
            }
        }
        return catCount == hatCount;
    }

    static void main() {
        CatAndHat c = new CatAndHat();
        System.out.println(c.catHat("catinahat"));
    }
}
