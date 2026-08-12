package com.example.geeksforgeeks.prefixsum;

import java.util.ArrayList;

public class PrefixSumArray {

    public static ArrayList<Integer> prefSum(int[] arr) {
        // to store the prefix sum
        ArrayList<Integer> prefixSum = new ArrayList<>();

        // initialize the first element
        prefixSum.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            prefixSum.add(prefixSum.get(i - 1) + arr[i]);
        }
        return prefixSum;
    }

    static void main() {
        int[] arr = {10, 20, 10, 5, 15};
        System.out.println(prefSum(arr));
    }
}
