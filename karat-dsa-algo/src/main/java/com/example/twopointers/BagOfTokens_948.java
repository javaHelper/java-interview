package com.example.twopointers;

import java.util.Arrays;

public class BagOfTokens_948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;

        while (left <= right) {
            // If we have enough power, play the smallest token face-up
            if (power >= tokens[left]) {
                power -= tokens[left];
                score++;
                left++;
                maxScore = Math.max(maxScore, score);
            }
            // Otherwise, if we have at least 1 score, play the largest token face-down
            else if (score > 0) {
                power += tokens[right];
                score--;
                right--;
            }
            // If neither is possible, break
            else {
                break;
            }
        }
        return maxScore;
    }
}
