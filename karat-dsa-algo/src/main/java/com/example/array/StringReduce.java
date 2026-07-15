package com.example.array;

public class StringReduce {
    public static int stringReduce(String str) {
        StringBuilder stack = new StringBuilder();

        for (char ch : str.toCharArray()) {
            int charCount = stack.length();
            if (charCount > 1) {
                int top = stack.charAt(charCount - 1);
                if ((top == '1' && ch == '0') || (top == '0' && ch == '1')) {
                    stack.deleteCharAt(stack.length() - 1);
                    continue;
                }
            }
            stack.append(ch);
        }
        return stack.length();
    }

    public static void main(String[] args) {
        System.out.println(stringReduce("100111"));
        System.out.println(stringReduce("000*111"));
    }
}