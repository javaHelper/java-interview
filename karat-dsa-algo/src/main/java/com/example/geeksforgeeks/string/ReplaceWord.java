package com.example.geeksforgeeks.string;

public class ReplaceWord {

    public String replaceAll(String s, String s1, String s2) {

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            if (s.startsWith(s1, i)) {
                ans.append(s2);
                i += s1.length();
            } else {
                ans.append(s.charAt(i));
                i++;
            }
        }

        return ans.toString();
    }

    static void main() {
        ReplaceWord sol = new ReplaceWord();
        System.out.println(sol.replaceAll("xxforxx xx for xx", "xx", "Geeks"));
    }
}
