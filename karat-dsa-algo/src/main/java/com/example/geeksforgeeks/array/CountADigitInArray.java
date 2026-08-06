package com.example.geeksforgeeks.array;

public class CountADigitInArray {

    public int countDigitK(int k, int[] arr) {
        int count = 0;

        // Iterate through each number in the array
        for (int num : arr) {
            // Handle the case when num is 0
            if (num == 0) {
                if (k == 0) {
                    count++;
                }
                continue;
            }

            // Extract digits one by one
            int temp = num;
            while (temp > 0) {
                int digit = temp % 10;      // Get the last digit
                if (digit == k) count++;    // Check if it matches k
                temp = temp / 10;           // Remove the last digit
            }
        }
        return count;
    }

    static void main() {
        CountADigitInArray x = new CountADigitInArray();
        System.out.println(x.countDigitK(1, new int[]{11, 12, 13, 14, 15}));
        System.out.println(x.countDigitK(3, new int[]{11, 121, 15}));
    }
}
