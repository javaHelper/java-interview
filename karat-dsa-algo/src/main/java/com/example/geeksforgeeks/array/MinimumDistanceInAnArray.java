package com.example.geeksforgeeks.array;

public class MinimumDistanceInAnArray {
    int minDist(int arr[], int x, int y) {
        int lastX = -1;
        int lastY = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                lastX = i;
                if (lastY != -1) {
                    minDist = Math.min(minDist, Math.abs(lastX - lastY));
                }
            } else if (arr[i] == y) {
                lastY = i;
                if (lastX != -1) {
                    minDist = Math.min(minDist, Math.abs(lastX - lastY));
                }
            }
        }
        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }

    static void main() {
        MinimumDistanceInAnArray x = new MinimumDistanceInAnArray();
        System.out.println(x.minDist(new int[]{1, 2, 3, 2}, 1, 2));
        System.out.println(x.minDist(new int[]{86, 39, 90, 67, 84, 66, 62}, 42, 12));
        System.out.println(x.minDist(new int[]{10, 20, 30, 40, 50}, 10, 50));
    }
}
