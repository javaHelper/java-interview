package com.example.dsa.tree.binarysearchtree;

public class GuessGame {
    private int target;

    public void setTarget(int target) {
        this.target = target;
    }

    int guess(int num) {
        if (num == target) {
            return 0;
        }
        return num < target ? 1 : -1;
    }
}