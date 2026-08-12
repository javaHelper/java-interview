package com.example.geeksforgeeks.array;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Given two integer arrays a[] and b[], find the numbers which are present in the first array a[],
 * but not present in the second array b[].
 *
 * Return the elements in the same order in which they appear in a[].
 *
 * Time Complexity: O(n + m) – one pass to build the set, one pass to filter.
 * Space Complexity: O(m) – for the HashSet.
 *
 * This is the standard and optimal approach for this problem
 */
public class MissingInSecondArray {

    public ArrayList<Integer> findMissing(int[] a, int[] b) {
        // Store all elements of b in a HashSet for O(1) lookup
        HashSet<Integer> setB = new HashSet<>();
        for (int num : b) {
            setB.add(num);
        }

        // Result list to store elements present in a but not in b
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : a) {
            if (!setB.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    static void main() {
        MissingInSecondArray sol = new MissingInSecondArray();
        System.out.println(sol.findMissing(new int[]{1, 2, 3, 4, 5, 10}, new int[]{2, 3, 1, 0,}));
    }
}
