package com.example.tree.treefundamentals;

public class RotateString_796 {
    public boolean rotateString(String s, String goal) {
        // Length must match for a valid rotation
        if (s.length() != goal.length()) {
            return false;
        }

        // All rotations of s are substrings of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }

    public static void main(String[] args) {
        RotateString_796 r = new RotateString_796();
        System.out.println(r.rotateString("abcde","cdeab"));
        System.out.println(r.rotateString("abcde","abcde"));
    }
}
