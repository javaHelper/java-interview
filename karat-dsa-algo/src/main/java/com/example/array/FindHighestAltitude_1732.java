package com.example.array;

public class FindHighestAltitude_1732 {

    public static void main(String[] args) {
        FindHighestAltitude_1732 x = new FindHighestAltitude_1732();
        System.out.println(x.largestAltitude(new int[]{-5, 1, 5, 0, -7}));
        System.out.println(x.largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}));
    }

    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;
        for (int g : gain) {
            currentAltitude += g;          // Update current altitude[reference:10]
            maxAltitude = Math.max(maxAltitude, currentAltitude); // Track maximum[reference:11]
        }
        return maxAltitude;
    }
}
