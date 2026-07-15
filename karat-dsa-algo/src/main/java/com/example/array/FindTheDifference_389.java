package com.example.array;

public class FindTheDifference_389 {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheDifference_389 f = new FindTheDifference_389();
        System.out.println(f.findTheDifference("abcd","abcde"));
        System.out.println(f.findTheDifference("", "y"));
    }
}
