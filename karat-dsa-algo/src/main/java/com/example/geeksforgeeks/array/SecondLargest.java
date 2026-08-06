package com.example.geeksforgeeks.array;

public class SecondLargest {
    public int getSecondLargest(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                // New largest found → shift previous largest to second
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                // New second largest found (strictly smaller than largest)
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    static void main() {
        SecondLargest sol = new SecondLargest();
        System.out.println(sol.getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}));
    }
}
