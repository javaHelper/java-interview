package com.example.dsa.stack;

public class RemoveAllAdjacentDuplicatesInString_1047 {

    /**
     * append()                  → push
     * deleteCharAt(length - 1)  → pop
     * charAt(length - 1)        → peek
     *
     *
     *
     *
     */
    public String removeDuplicates(String s) {
        //
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

    static void main() {
        RemoveAllAdjacentDuplicatesInString_1047 x = new RemoveAllAdjacentDuplicatesInString_1047();
        System.out.println(x.removeDuplicates("abbaca"));
        System.out.println(x.removeDuplicates("azxxzy"));
    }
}
