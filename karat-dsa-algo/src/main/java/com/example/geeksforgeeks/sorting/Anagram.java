package com.example.geeksforgeeks.sorting;

public class Anagram {
    public static boolean areAnagrams(String s1, String s2) {
        // base case
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }


        for(int num: freq){
            if(num != 0){
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println(Anagram.areAnagrams("geeks","kseeg"));
    }
}
