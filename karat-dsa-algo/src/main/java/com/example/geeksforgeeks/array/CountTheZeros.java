package com.example.geeksforgeeks.array;

public class CountTheZeros {
    int countZeroes(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int firstZero = arr.length; // assume no zero

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 0) {
                firstZero = mid;      // found a zero, but maybe there's an earlier one
                right = mid - 1;       // search left side
            } else {
                left = mid + 1;
            }
        }
        return arr.length - firstZero;
    }

    static void main() {
        CountTheZeros sol = new CountTheZeros();
        System.out.println(sol.countZeroes(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}));
        System.out.println(sol.countZeroes(new int[]{0, 0, 0, 0}));
    }
}
