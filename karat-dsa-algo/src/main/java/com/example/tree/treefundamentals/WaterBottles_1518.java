package com.example.tree.treefundamentals;

public class WaterBottles_1518 {
    public static void main(String[] args) {
        WaterBottles_1518 w = new WaterBottles_1518();
        System.out.println(w.numWaterBottles(9,3));
        System.out.println(w.numWaterBottles(15,4));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
