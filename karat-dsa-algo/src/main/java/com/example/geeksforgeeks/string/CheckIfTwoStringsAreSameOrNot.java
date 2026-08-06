package com.example.geeksforgeeks.string;

public class CheckIfTwoStringsAreSameOrNot {

    public static boolean areStringsSame(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println(CheckIfTwoStringsAreSameOrNot.areStringsSame("abc", "abc"));
        System.out.println(CheckIfTwoStringsAreSameOrNot.areStringsSame(" ", " "));
        System.out.println(CheckIfTwoStringsAreSameOrNot.areStringsSame("geeks", "Geeks"));
    }
}
