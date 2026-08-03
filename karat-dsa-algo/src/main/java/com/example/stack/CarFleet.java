package com.example.stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        // Create pairs of (position, speed)
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position in descending order (closest to target first)[reference:5]
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack to store the arrival times of fleets[reference:6]
        Stack<Double> stack = new Stack<>();

        for (int[] car : cars) {
            int pos = car[0];
            int spd = car[1];
            double time = (double) (target - pos) / spd; // Time to reach target[reference:7]

            // If the stack is empty, or this car arrives later than the fleet ahead,
            // it cannot catch up → forms a new fleet.[reference:8]
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
            // Otherwise, time <= stack.peek(): this car catches up and merges.
            // We do NOT push it to the stack.
        }

        // The size of the stack equals the number of fleets.[reference:9]
        return stack.size();
    }

    static void main() {

    }
}
