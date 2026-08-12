package com.example.geeksforgeeks.string;

public class FirstRepeatedCharacter {

    String firstRepChar(String s) {
        int[] freq = new int[26];
        String str = "";

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            if (freq[s.charAt(i) - 'a'] > 1) {
                str += s.charAt(i);
                return str;
            }
        }
        return "-1";
    }

   /*
        Time: O(n)
        Space: O(1)
    */
    String firstRepCharUsingBoolean(String s) {
        boolean[] seen = new boolean[26];
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx]) {
                return String.valueOf(c);
            }
            seen[idx] = true;
        }

        return "-1";
    }

    static void main() {
        FirstRepeatedCharacter sol = new FirstRepeatedCharacter();
        System.out.println(sol.firstRepChar("geeksforgeeks"));
        System.out.println(sol.firstRepChar("hellogeeks"));
        System.out.println(sol.firstRepChar("abc"));
        System.out.println("---------------------------");
        System.out.println(sol.firstRepCharUsingBoolean("geeksforgeeks"));
        System.out.println(sol.firstRepCharUsingBoolean("hellogeeks"));
        System.out.println(sol.firstRepCharUsingBoolean("abc"));
    }
}
