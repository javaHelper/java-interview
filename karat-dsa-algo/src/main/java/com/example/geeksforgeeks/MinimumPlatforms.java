package com.example.geeksforgeeks;

import java.util.Arrays;

public class MinimumPlatforms {
    public int minPlatform(int arr[], int dep[]) {
        // Sort both arrays separately
        Arrays.sort(arr);
        Arrays.sort(dep);

        // Current platforms needed
        int platforms = 1;

        // Maximum platforms needed so far
        int maxPlatforms = 1;

        // Points to the next arrival (starts from 2nd train)
        int left = 1;

        // Points to the next departure (starts from 1st train)
        int right = 0;

        while (left < arr.length && right < arr.length) {
            // If the next train arrives BEFORE or AT the same time the earliest
            // train departs, we need an extra platform.
            if (arr[left] <= dep[right]) {
                platforms++;
                maxPlatforms = Math.max(maxPlatforms, platforms);
                left++; // Move to the next arrival
            } else {
                // A train has departed, so a platform becomes free.
                platforms--;
                right++;
            }
        }
        return maxPlatforms;
    }

    static void main() {
        MinimumPlatforms sol = new MinimumPlatforms();

        // Example 1: Expected output = 3
        int[] arr1 = {900, 940, 950, 1100, 1500, 1800};
        int[] dep1 = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println("Example 1: " + sol.minPlatform(arr1, dep1)); // 3

        // Example 2: Expected output = 1
        int[] arr2 = {900, 1235, 1100};
        int[] dep2 = {1000, 1240, 1200};
        System.out.println("Example 2: " + sol.minPlatform(arr2, dep2)); // 1

        // Example 3: All trains overlap -> Expected = 3
        int[] arr3 = {900, 910, 920};
        int[] dep3 = {930, 940, 950};
        System.out.println("Example 3: " + sol.minPlatform(arr3, dep3)); // 3
    }
}
