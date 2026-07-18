package com.example.tree.treefundamentals;

public class FindTheDifference_389 {
    // explicit assignment with XOR expression
    public char findTheDifference(String s, String t) {
        char diff = 0;
        for (char c : s.toCharArray()) {
            diff = (char) (diff ^ c);
        }
        for (char c : t.toCharArray()) {
            diff = (char) (diff ^ c);
        }
        return diff;
    }

    // This is compound assignment ==> result ^= c;
    /*public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }*/

    public static void main(String[] args) {
        FindTheDifference_389 f = new FindTheDifference_389();
        System.out.println(f.findTheDifference("abcd", "abcde"));
        System.out.println(f.findTheDifference("", "y"));
    }
}
