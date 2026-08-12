package com.example.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters_316 {
    public String removeDuplicateLetters(String s) {
        int[] frequency = new int[26];
        boolean[] visited = new boolean[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            frequency[index]--;

            // Already included in result
            if (visited[index]) {
                continue;
            }

            // Remove larger characters if they appear again later
            while (!stack.isEmpty() && stack.peek() > ch && frequency[stack.peek() - 'a'] > 0) {
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }
            stack.push(ch);
            visited[index] = true;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.removeLast());
        }
        return result.toString();
    }
}
