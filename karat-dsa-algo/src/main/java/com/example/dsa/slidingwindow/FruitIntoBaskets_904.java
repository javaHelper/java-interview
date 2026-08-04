package com.example.dsa.slidingwindow;

public class FruitIntoBaskets_904 {

    public int totalFruit(int[] fruits) {
        int lastFruit = -1;        // Most recent fruit type
        int secondLastFruit = -1;  // Second most recent fruit type
        int lastFruitCount = 0;    // Consecutive count of the most recent fruit
        int maxFruits = 0;
        int currentMax = 0;

        for (int fruit : fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit) {
                currentMax++;
            } else {
                // New fruit type → window resets to lastFruitCount + 1
                currentMax = lastFruitCount + 1;
            }

            // Update lastFruitCount: consecutive count of the most recent fruit
            if (fruit == lastFruit) {
                lastFruitCount++;
            } else {
                lastFruitCount = 1;
            }

            // Update the two most recent fruit types
            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            maxFruits = Math.max(maxFruits, currentMax);
        }

        return maxFruits;
    }
}
