package com.example.geeksforgeeks.array;

import java.util.Arrays;

public class MergeTwoUnsortedArrays {
    public int[] sortedMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int index = 0;

        for (int num : a) {
            result[index++] = num;
        }
        for (int num : b) {
            result[index++] = num;
        }
        Arrays.sort(result);
        return result;
    }

    static void main() {
        MergeTwoUnsortedArrays sol = new MergeTwoUnsortedArrays();
        System.out.println(Arrays.toString(sol.sortedMerge(new int[]{10, 5, 15}, new int[]{20, 3, 2})));
    }
}
