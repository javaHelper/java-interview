package com.example.karatprep;

import java.util.ArrayList;
import java.util.List;

public class SeparateLine {
    public List<String> separateLine(String input, int n) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int len = input.length();

        while (i < len) {
            // Find the end of the current line:
            // try to take n characters starting from i.
            int end = Math.min(i + n, len);

            // If we reached the end, just add the remaining substring.
            if (end == len) {
                result.add(input.substring(i));
                break;
            }

            // If the character at 'end' is a space, we can cut exactly at 'end'.
            if (input.charAt(end) == ' ') {
                result.add(input.substring(i, end + 1)); // include the space
                i = end + 1;
                continue;
            }

            // Otherwise, we need to find the last space within the range [i, end).
            int lastSpace = input.lastIndexOf(' ', end - 1);

            // If no space is found, it means the current word is longer than n.
            if (lastSpace < i) {
                throw new IllegalArgumentException(
                        "Word starting at index " + i + " is longer than " + n
                );
            }

            // Cut at the space (include the space in the line).
            result.add(input.substring(i, lastSpace + 1));
            i = lastSpace + 1;
        }

        return result;
    }

    // Alternative: return lines without trailing spaces (trimmed)
    public List<String> separateLineTrimmed(String input, int n) {
        List<String> raw = separateLine(input, n);
        List<String> trimmed = new ArrayList<>();
        for (String line : raw) {
            trimmed.add(line.trim());
        }
        return trimmed;
    }

    // Example usage
    public static void main(String[] args) {
        SeparateLine sol = new SeparateLine();
        String text = "Given a string and an int - split a text into lines with length as close as possible to the given int WITHOUT breaking words in the middle.";
        int n = 15;

        List<String> lines = sol.separateLine(text, n);
        for (String line : lines) {
            System.out.println("\"" + line + "\"");
        }
    }
}
