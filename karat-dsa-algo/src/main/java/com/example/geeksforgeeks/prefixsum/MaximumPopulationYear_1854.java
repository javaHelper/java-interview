package com.example.geeksforgeeks.prefixsum;

public class MaximumPopulationYear_1854 {

    public int maximumPopulation(int[][] logs) {
        int[] diff = new int[101];

        for (int[] log : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        int maxPopulation = 0;
        int currentPopulation = 0;
        int answer = 1950;

        for (int i = 0; i < 101; i++) {
            currentPopulation += diff[i];

            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                answer = i + 1950;
            }
        }
        return answer;
    }

    static void main() {
        int[][] logs = {
                {1993, 1999},
                {2000, 2010}
        };
        MaximumPopulationYear_1854 x = new MaximumPopulationYear_1854();
        System.out.println(x.maximumPopulation(logs));
    }
}
