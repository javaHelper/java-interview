package com.example.geeksforgeeks.string;

// https://www.geeksforgeeks.org/problems/implement-strstr/1?page=1&category=Strings,Hash,Sorting
public class FirstOccurence {

    int firstOccurence(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        if (m == 0) {
            return 0;
        }
        if (m > n) {
            return -1;
        }
        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if(j == m){
                return i;
            }
        }
        return -1;
    }

    static void main() {
        FirstOccurence f = new FirstOccurence();
        System.out.println(f.firstOccurence("GeeksForGeeks","Fr"));
    }
}
