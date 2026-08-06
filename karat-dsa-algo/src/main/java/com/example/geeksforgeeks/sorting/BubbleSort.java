package com.example.geeksforgeeks.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    static void main() {
        // Test Case 1: Unsorted array
        int[] arr1 = {4, 1, 3, 9, 7};
        System.out.println("Original: " + Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println("Sorted:   " + Arrays.toString(arr1));
        // Expected: [1, 3, 4, 7, 9]
    }
}
