package com.example.geeksforgeeks.string;

/*

    You are given a string s consisting of lowercase english letters.
    Your task is to count how many distinct characters appear an even number of times in the string.

 */
public class CountEvenLetters {

    public int count(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int count = 0;
        for (int num : freq) {
            if (num > 0 && num % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static void main() {
        CountEvenLetters sol = new CountEvenLetters();
        System.out.println(sol.count("abacaba"));
        System.out.println(sol.count("zzacccz"));
    }
}
