package com.example.dsa.tree.binarysearchtree;

public class Sqrt_x_69 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }
            if (square < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    static void main() {
        Sqrt_x_69 x = new Sqrt_x_69();
        System.out.println(x.mySqrt(16));
        System.out.println(x.mySqrt(8));
    }
}
