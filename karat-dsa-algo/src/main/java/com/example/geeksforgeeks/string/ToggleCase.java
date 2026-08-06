package com.example.geeksforgeeks.string;

public class ToggleCase {
    public String toggleCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
        }
        return sb.toString();
    }

    static void main() {
        ToggleCase sol = new ToggleCase();
        System.out.println(sol.toggleCase("geeksForgEeks"));
    }
}
