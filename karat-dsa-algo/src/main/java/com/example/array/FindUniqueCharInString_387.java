package com.example.array;

public class FindUniqueCharInString_387 {
    public int firstUniqChar(String s) {
        // Step 1: frequency array for 26 letters
        int[] freq = new int[26];

        // Step2: count occurrence of each char
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq[c - 'a']++;
        }

        // Step 3: Find the first character with count == 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[c - 'a'] == 1) {
                return i;
            }
        }
        // No unique character found
        return -1;
    }
    static void main() {
        FindUniqueCharInString_387 x = new FindUniqueCharInString_387();
        System.out.println(x.firstUniqChar("leetcode"));
        System.out.println(x.firstUniqChar("loveleetcode"));
        System.out.println(x.firstUniqChar("aabb"));
    }
}
