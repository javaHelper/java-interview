package com.example.geeksforgeeks.string;

public class RunLengthEncoding {
    public static String encode(String s) {
        StringBuilder result = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                result.append(s.charAt(i - 1));
                result.append(count);
                count = 1;
            }
        }
        return result.toString();
    }

    static void main() {
        System.out.println(encode("aaaabbbccc"));
    }
}
