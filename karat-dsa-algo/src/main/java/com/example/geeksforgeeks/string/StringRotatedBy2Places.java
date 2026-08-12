package com.example.geeksforgeeks.string;

public class StringRotatedBy2Places {
    public static boolean isRotated(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() < 2) {
            return s1.equals(s2);
        }

        // Left rotation by 2
        String left = s1.substring(2) + s1.substring(0, 2);

        // Right rotation by 2
        String right = s1.substring(s1.length() - 2) + s1.substring(0, s1.length() - 2);
        return s2.equals(left) || s2.equals(right);
    }

    static void main() {
        System.out.println(StringRotatedBy2Places.isRotated("amazon", "azonam"));
        System.out.println(StringRotatedBy2Places.isRotated("geeksforgeeks", "geeksgeeksfor"));
    }
}
