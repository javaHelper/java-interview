package com.example.geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Time: O(n log n)
 * Space: O(n)
 * Result: Passes all GFG tests ✅
 */
public class SegregateEvenAndOddNumbers {

    public void segregateEvenOdd(int[] arr) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        // Step 1: Separate even and odd numbers
        for (int num : arr) {
            if (num % 2 == 0) {
                evens.add(num);
            } else {
                odds.add(num);
            }
        }

        // Step 2: Sort both lists
        Collections.sort(evens);
        Collections.sort(odds);

        // Step 3: Merge back into the original array
        int index = 0;
        for (int num : evens) {
            arr[index++] = num;
        }
        for (int num : odds) {
            arr[index++] = num;
        }
    }

    static void main() {
        SegregateEvenAndOddNumbers sol = new SegregateEvenAndOddNumbers();

        // Example 1
        int[] arr1 = {12, 34, 45, 9, 8, 90, 3};
        sol.segregateEvenOdd(arr1);
        System.out.println(Arrays.toString(arr1)); // [8, 12, 34, 90, 3, 9, 45]

        // Example 2
        int[] arr2 = {0, 1, 2, 3, 4};
        sol.segregateEvenOdd(arr2);
        System.out.println(Arrays.toString(arr2)); // [0, 2, 4, 1, 3]

        // Example 3
        int[] arr3 = {10, 22, 4, 6};
        sol.segregateEvenOdd(arr3);
        System.out.println(Arrays.toString(arr3)); // [4, 6, 10, 22]
    }
}
