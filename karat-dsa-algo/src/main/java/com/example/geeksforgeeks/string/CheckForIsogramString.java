package com.example.geeksforgeeks.string;

public class CheckForIsogramString {
    static boolean isIsogram(String data) {
        int[] freq = new int[26];
        for (char c : data.toCharArray()) {
            freq[c - 'a']++;
        }

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
