package com.example.geeksforgeeks;

public class HammingDistanceTwoString {
    int hammingDist(String str1, String str2) {
        int i = 0;
        int count = 0;
        while (i < str1.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
            i++;
        }
        return count;
    }

    static void main() {
        HammingDistanceTwoString hd = new HammingDistanceTwoString();
        System.out.println(hd.hammingDist("geekspractice","nerdspractise"));
    }
}
