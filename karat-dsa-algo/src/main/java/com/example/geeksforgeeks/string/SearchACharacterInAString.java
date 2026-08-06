package com.example.geeksforgeeks.string;

public class SearchACharacterInAString {
    public  int searchCharacter(String s, char ch) {
        // Traverse the string character by character[reference:3]
        for (int i = 0; i < s.length(); i++) {
            // If current character matches, return its index[reference:4]
            if (s.charAt(i) == ch) {
                return i;
            }
        }
        // Character not found[reference:5]
        return -1;
    }

    static void main() {
        SearchACharacterInAString sol = new SearchACharacterInAString();
        System.out.println(sol.searchCharacter("geeksforgeeks", 'k'));
    }
}
