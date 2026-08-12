package com.example.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }
        return result.isEmpty() ? "/" : result.toString();
    }

    static void main() {

    }
}
