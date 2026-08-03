package com.example.string;

public class NumberOfSegmentsInString_434 {
    public int countSegments(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        return count;
    }

    static void main() {
        NumberOfSegmentsInString_434 s = new NumberOfSegmentsInString_434();
        System.out.println(s.countSegments("Hello, my name is John"));
        System.out.println(s.countSegments("Hello"));
    }
}
