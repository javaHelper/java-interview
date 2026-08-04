package com.example.dsa.greedy;

import java.util.Arrays;

public class Candy_135 {

    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] candies = new int[n];

        // Step 1: Give every child at least 1 candy
        Arrays.fill(candies, 1);

        // Step 2: Left-to-right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Right-to-left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Sum up
        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

    static void main() {
        Candy_135 c = new Candy_135();
        System.out.println(c.candy(new int[]{1, 0, 2}));
    }
}
