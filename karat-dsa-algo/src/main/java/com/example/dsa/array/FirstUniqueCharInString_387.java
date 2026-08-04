package com.example.dsa.array;

public class FirstUniqueCharInString_387 {

    public int firstUniqChar(String s) {
        // Step 1: frequency array for 26 letters
        int[] freq = new int[26];

        // Step2: count occurrence of each char
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Step 3: Find the first character with count == 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        // No unique character found
        return -1;
    }
    static void main() {
        FirstUniqueCharInString_387 x = new FirstUniqueCharInString_387();
        System.out.println(x.firstUniqChar("leetcode"));
        System.out.println(x.firstUniqChar("loveleetcode"));
        System.out.println(x.firstUniqChar("aabb"));
    }
}
