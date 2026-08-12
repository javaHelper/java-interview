package com.example.geeksforgeeks.array;

// https://www.geeksforgeeks.org/problems/easy-string2212/1
public class CompressString {

    public String compressString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char prev = Character.toLowerCase(s.charAt(0));
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            char curr = Character.toLowerCase(s.charAt(i));
            if (curr == prev) {
                count++;
            } else {
                result.append(prev).append(count); // char then count
                prev = curr;
                count = 1;
            }
        }
        result.append(prev).append(count); // last group
        return result.toString();
    }

    static void main() {
        CompressString c = new CompressString();
        System.out.println(c.compressString("aaABBb")); //3a3b
        System.out.println(c.compressString("aaacca")); // 3a2c1a
    }
}
