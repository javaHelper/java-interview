package com.example.low;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        // Count unique candy types
        Set<Integer> uniqueTypes = new HashSet<>();
        for (int type : candyType) {
            uniqueTypes.add(type);
        }

        // Maximum different types Alice can eat
        int maxAllowed = candyType.length / 2;
        return Math.min(uniqueTypes.size(), maxAllowed);
    }

    static void main() {
        DistributeCandies c = new DistributeCandies();
        System.out.println(c.distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
