package com.example.dsa.stack;

public class StringReduce_interview {
    public static int stringReduce(String str) {
        StringBuilder stack = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.charAt(stack.length() - 1);

                if ((top == '0' && ch == '1') || (top == '1' && ch == '0')) {
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