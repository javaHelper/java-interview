package com.example.karatprep;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopWords {
    public List<String> getTopWords(String[] s, int wordLimit, int minWordLength) {
        // Max‑heap: highest count at top
        PriorityQueue<String> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.parseInt(b.split(",\\s*")[1]) - Integer.parseInt(a.split(",\\s*")[1])
        );

        for (String entry : s) {
            String[] parts = entry.split(",\\s*");
            String word = parts[0];
            if (word.length() >= minWordLength) {
                maxHeap.offer(entry);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < wordLimit && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    static void main(String[] args) {
        TopWords tw = new TopWords();

        // Example input from the LeetCode discussion
        String[] s = {
                "abc, 500",
                "sadhasjhkgdsak, 230239203",
                "fsgdfssd, 78",
                "sss, 56",
                "ss, 56",
                "sss, 5678",
                "sssdsds, 56",
                "ssssdsd, 56"
        };

        int wordLimit = 3;
        int minWordLength = 3;

        List<String> topWords = tw.getTopWords(s, wordLimit, minWordLength);
        for (String entry : topWords) {
            System.out.println(entry);
        }
    }
}
