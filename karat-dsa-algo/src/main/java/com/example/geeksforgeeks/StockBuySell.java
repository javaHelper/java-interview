package com.example.geeksforgeeks;

public class StockBuySell {
    public int stockBuySell(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            // If price goes up, we could have made profit
            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }

    static void main() {
        StockBuySell sol = new StockBuySell();
        System.out.println(sol.stockBuySell(new int[]{100, 180, 260, 310, 40, 535, 695}));
    }
}
