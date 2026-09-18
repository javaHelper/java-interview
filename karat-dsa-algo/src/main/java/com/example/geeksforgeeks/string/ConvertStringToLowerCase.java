package com.example.geeksforgeeks.string;

public class ConvertStringToLowerCase {
    static String toLower(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                System.out.println(chars[i] + 32);
                chars[i] = (char) (chars[i] + 32);
            }
        }

        return new String(chars);
    }

    static String toUpper(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i] - 32);
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }

    static void main() {
        System.out.println(ConvertStringToLowerCase.toLower("ABCddE"));
        System.out.println("---------------------");
        System.out.println(ConvertStringToLowerCase.toUpper("ABCddE"));
    }
}
