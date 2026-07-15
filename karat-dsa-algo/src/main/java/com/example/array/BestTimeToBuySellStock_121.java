package com.example.array;

public class BestTimeToBuySellStock_121 {
    static void main() {
        BestTimeToBuySellStock_121 x = new BestTimeToBuySellStock_121();
        System.out.println(x.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(x.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int answer = 0;

        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minSoFar;
            if (profit > answer) {
                answer = profit;
            }
            minSoFar = Math.min(prices[i], minSoFar);
        }
        return answer;
    }
}
