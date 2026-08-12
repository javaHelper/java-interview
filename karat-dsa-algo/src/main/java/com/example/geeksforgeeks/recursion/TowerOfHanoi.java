package com.example.geeksforgeeks.recursion;

public class TowerOfHanoi {
    public long towerOfHanoi(int n, int from, int to, int aux) {
        // Base case: 0 disks require 0 moves
        if (n == 0) {
            return 0;
        }

        // Recursive relation: moves(n) = 2 * moves(n-1) + 1
        // This corresponds to:
        // 1. Move n-1 disks from 'from' to 'aux' using 'to' as helper
        // 2. Move the largest disk from 'from' to 'to'
        // 3. Move n-1 disks from 'aux' to 'to' using 'from' as helper
        return 2 * towerOfHanoi(n - 1, from, aux, to) + 1;
    }

    static void main() {
        TowerOfHanoi x = new TowerOfHanoi();

        // Test cases
        int[] testInputs = {0, 1, 2, 3, 4, 5};

        for (int n : testInputs) {
            long moves = x.towerOfHanoi(n, 1, 3, 2);
            System.out.println("n = " + n + " → Minimum moves: " + moves);
        }
    }
}
