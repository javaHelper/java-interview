package com.example.geeksforgeeks.array;

import java.util.Arrays;

public class MoveAllNegativeElementsToEnd {
    public void segregateElements(int[] arr) {
        int[] temp = new int[arr.length];
        int idx = 0;

        // Copy all non‑negative (>= 0) elements first
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                temp[idx++] = arr[i];
            }
        }

        // Copy all negative elements after that
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                temp[idx++] = arr[i];
            }
        }

        // Copy back to the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    static void main() {
        MoveAllNegativeElementsToEnd x = new MoveAllNegativeElementsToEnd();
        int[] arr = new int[]{1, -1, 3, 2, -7, -5, 11, 6};
        System.out.println("After segregation: " + Arrays.toString(arr));
        x.segregateElements(arr);
        System.out.println("After segregation: " + Arrays.toString(arr));
    }
}
