package com.example.karatprep;

import java.util.ArrayList;
import java.util.List;

public class JustifyText {
    public List<String> justify(String[] text, int lineLength) {
        // Step 1: Flatten all words into a single list
        List<String> words = new ArrayList<>();
        for (String line : text) {
            // Split on whitespace and add non-empty words
            for (String word : line.trim().split("\\s+")) {
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        }

        List<String> result = new ArrayList<>();
        int n = words.size();
        int start = 0;

        while (start < n) {
            // Step 2: Greedily pack as many words as possible on this line
            int end = start;
            int lineLengthSoFar = words.get(start).length();

            while (end + 1 < n) {
                int nextWordLength = words.get(end + 1).length();
                // +1 for the space between words
                if (lineLengthSoFar + 1 + nextWordLength <= lineLength) {
                    lineLengthSoFar += 1 + nextWordLength;
                    end++;
                } else {
                    break;
                }
            }

            // Step 3: Build the justified line
            int wordCount = end - start + 1;
            int totalSpaces = lineLength - lineLengthSoFar;  // spaces to distribute

            // Single word or last line: left-justify
            if (wordCount == 1 || end == n - 1) {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i <= end; i++) {
                    sb.append(words.get(i));
                    if (i < end) sb.append(' ');
                }
                // Pad remaining spaces to the right
                while (sb.length() < lineLength) {
                    sb.append(' ');
                }
                result.add(sb.toString());
            } else {
                // Fully justified: distribute spaces evenly between words
                int gaps = wordCount - 1;
                int spacesPerGap = totalSpaces / gaps;
                int extraSpaces = totalSpaces % gaps;  // leftmost gaps get one extra

                StringBuilder sb = new StringBuilder();
                for (int i = start; i <= end; i++) {
                    sb.append(words.get(i));
                    if (i == end) break;  // no space after last word

                    int spacesToAdd = spacesPerGap + (extraSpaces > 0 ? 1 : 0);
                    if (extraSpaces > 0) extraSpaces--;

                    for (int s = 0; s < spacesToAdd; s++) {
                        sb.append(' ');
                    }
                }
                result.add(sb.toString());
            }

            start = end + 1;
        }

        return result;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        JustifyText jt = new JustifyText();

        // Example 1
        String[] text1 = {"Some modern typesetting programs", "offer four justification", "options"};
        System.out.println("Example 1 (lineLength = 24):");
        jt.justify(text1, 24).forEach(System.out::println);
        System.out.println();

        // Example 2
        String[] text2 = {"The Earth is", "the only world", "known so far", "to harbor life"};
        System.out.println("Example 2 (lineLength = 18):");
        jt.justify(text2, 18).forEach(System.out::println);
        System.out.println();

        // Example 3
        String[] text3 = {"It underscores our responsibility", "to deal more kindly with one another"};
        System.out.println("Example 3 (lineLength = 15):");
        jt.justify(text3, 15).forEach(System.out::println);
    }
}
