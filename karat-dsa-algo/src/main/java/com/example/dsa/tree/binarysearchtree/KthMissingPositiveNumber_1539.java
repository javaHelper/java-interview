package com.example.dsa.tree.binarysearchtree;

public class KthMissingPositiveNumber_1539 {

    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = arr[mid] - (mid + 1);

            if (missing < k)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left + k;
    }

    static void main() {
        KthMissingPositiveNumber_1539 k = new KthMissingPositiveNumber_1539();
        System.out.println(k.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(k.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}
