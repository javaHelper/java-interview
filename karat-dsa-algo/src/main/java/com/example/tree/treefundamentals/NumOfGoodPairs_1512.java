package com.example.tree.treefundamentals;

import java.util.HashMap;
import java.util.Map;

public class NumOfGoodPairs_1512 {
    public int numIdenticalPairs(int[] nums) {
        // Map to store frequency of each number
        Map<Integer, Integer> frequency = new HashMap<>();

        int goodPair = 0;
        for (int num : nums) {
            // If this number has been seen before,
            // it can form a good pair with every previous occurrence.
            Integer count = frequency.getOrDefault(num, 0);
            goodPair = goodPair + count;
            System.out.println("Current Number: " + num + ", Count: " + count + ", Good Pairs: " + goodPair);

            // Increment frequency for future occurences
            frequency.put(num, count + 1);
            System.out.println("Frequency Map: " + frequency);
        }
        return goodPair;
    }

    public static void main(String[] args) {
        NumOfGoodPairs_1512 x = new NumOfGoodPairs_1512();

        System.out.println(x.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println("------------------------------------------");
        System.out.println(x.numIdenticalPairs(new int[]{4, 1, 4, 4}));
    }
}
