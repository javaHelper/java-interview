package com.example.tree.treefundamentals;

public class RemoveAdjDuplicatesInString {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            int length = stack.length();
            // If the stack is not empty and the top character matches the current one
            if (length != 0 && stack.charAt(length - 1) == c) {
                // Pop the top character (remove the previous duplicate)
                stack.setLength(length - 1);
            } else {
                // Push the current character onto the stack
                stack.append(c);
            }
        }
        // The stack now contains the final string without adjacent duplicates
        return stack.toString();
    }

    public static void main(String[] args) {
        RemoveAdjDuplicatesInString solution = new RemoveAdjDuplicatesInString();
        System.out.println(solution.removeDuplicates("abbaca")); // Output: "ca"
        System.out.println(solution.removeDuplicates("azxxzy")); // Output: "ay"
        System.out.println(solution.removeDuplicates("aababaab")); // Output: "b"
        System.out.println(solution.removeDuplicates("a")); // Output: "a"
        System.out.println(solution.removeDuplicates("")); // Output: ""
        System.out.println(solution.removeDuplicates("aa")); // Output: ""
        System.out.println(solution.removeDuplicates("abccba")); // Output: ""
        System.out.println(solution.removeDuplicates("abcddcba")); // Output: ""
    }
}
