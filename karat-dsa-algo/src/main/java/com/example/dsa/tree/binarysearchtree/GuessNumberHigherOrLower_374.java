package com.example.dsa.tree.binarysearchtree;

public class GuessNumberHigherOrLower_374 extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int result = guess(mid);

            if (result == 0) return mid;
            else if (result == 1) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    static void main() {
        GuessNumberHigherOrLower_374 x = new GuessNumberHigherOrLower_374();

        x.setTarget(6);
        System.out.println(x.guessNumber(10));

        x.setTarget(1);
        System.out.println(x.guessNumber(1));

        x.setTarget(2);
        System.out.println(x.guessNumber(2));
    }
}
