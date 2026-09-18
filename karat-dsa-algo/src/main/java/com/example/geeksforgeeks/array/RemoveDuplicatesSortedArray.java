package com.example.geeksforgeeks.array;

import java.util.ArrayList;

/*

    You are given a sorted array arr[] containing positive integers.
    Your task is to remove all duplicate elements from this array such that each element appears only once.
    Return an array containing these distinct elements in the same order as they appeared.

 */
public class RemoveDuplicatesSortedArray {

    ArrayList<Integer> removeDuplicates(int[] arr) {
        // Edge case: null or empty array
        if (arr == null || arr.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> result = new ArrayList<>();

        // First element is always included
        result.add(arr[0]);

        // Traverse from second element onward
        for (int i = 1; i < arr.length; i++) {
            // If current element is different from the previous one, it's a new distinct element
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        return result;
    }

    static void main() {
        RemoveDuplicatesSortedArray x = new RemoveDuplicatesSortedArray();
        System.out.println(x.removeDuplicates(new int[]{2, 2, 2, 2, 2}));
    }
}
