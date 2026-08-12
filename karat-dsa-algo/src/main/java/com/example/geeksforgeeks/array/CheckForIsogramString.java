package com.example.geeksforgeeks.array;

/**
 * Given a string s of lowercase alphabets, check if it is Isogram or not.
 * An Isogram is a string in which no letter occurs more than once.
 */
// https://www.geeksforgeeks.org/problems/check-if-a-string-is-isogram-or-not-1587115620/1
public class CheckForIsogramString {
    static boolean isIsogram(String data) {
        int[] freq = new int[26];
        for (char c : data.toCharArray()) {
            freq[c - 'a']++;
        }

        // Iterate over values
        for (int num: freq){
            if(num > 1){
                return false;
            }
        }
        return true;
    }

    static void main() {
        System.out.println(CheckForIsogramString.isIsogram("machine"));
        System.out.println(CheckForIsogramString.isIsogram("geeks"));
    }
}
