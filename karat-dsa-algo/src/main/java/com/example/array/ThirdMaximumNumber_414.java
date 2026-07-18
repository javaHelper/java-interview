package com.example.array;

public class ThirdMaximumNumber_414 {
    public int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int num : nums) {
            long n = num;
            // Skip duplicates – we only care about distinct values
            if (n == first || n == second || n == third) {
                continue;
            }
            // Update the top three distinct maximums
            if (n > first) {
                third = second;
                second = first;
                first = n;
            } else if (n > second) {
                third = second;
                second = n;
            } else if (n > third) {
                third = n;
            }
        }
        // If third was never updated, there is no third distinct maximum
        return (third == Long.MIN_VALUE) ? (int) first : (int) third;
    }

    static void main() {
        ThirdMaximumNumber_414 x = new ThirdMaximumNumber_414();
        System.out.println(x.thirdMax(new int[]{3, 2, 1}));
        System.out.println(x.thirdMax(new int[]{1, 2}));
        System.out.println(x.thirdMax(new int[]{2, 2, 3, 1}));
    }
}
