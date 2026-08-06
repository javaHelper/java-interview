package com.example.geeksforgeeks.array;

public class LargestPairSum {

    public int pairsum(int[] arr) {
        // Find the two largest elements in the array
        int largest = 0;
        int secondLargest = 0;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                secondLargest = num;
            }
        }
        return largest + secondLargest;
    }

    static void main() {
        LargestPairSum x = new LargestPairSum();
        System.out.println(x.pairsum(new int[]{12, 34, 10, 6, 40}));
        System.out.println(x.pairsum(new int[]{10, 20, 3}));
    }
}
