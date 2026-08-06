package com.example.geeksforgeeks.string;

public class RemoveACharacterFromAGivenPosition {
    public String removeCharacter(String s, int pos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (pos != i) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    static void main() {
        RemoveACharacterFromAGivenPosition sol = new RemoveACharacterFromAGivenPosition();
        System.out.println(sol.removeCharacter("abcde", 1));
    }
}
