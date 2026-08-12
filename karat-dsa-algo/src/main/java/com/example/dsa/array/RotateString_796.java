package com.example.dsa.array;

public class RotateString_796 {
    public boolean rotateString1(String s, String goal) {
        // Length must match for a valid rotation
        if (s.length() != goal.length()) {
            return false;
        }

        // All rotations of s are substrings of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }


    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        for (int shift = 0; shift < n; shift++) {
            boolean match = true;

            for (int i = 0; i < n; i++) {
                if (s.charAt((i + shift) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        RotateString_796 r = new RotateString_796();
        System.out.println(r.rotateString("abcde", "cdeab"));
        System.out.println(r.rotateString("abcde", "abcde"));
    }
}
