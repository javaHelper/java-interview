package com.example.slidingwindow;

import org.junit.jupiter.api.Test;

public class FruitIntoBaskets_904Test {
    FruitIntoBaskets_904 sol = new FruitIntoBaskets_904();

    @Test
    void FruitIntoBaskets1(){
        int[] fruits1 = {1, 2, 1};
        System.out.println("Output: " + sol.totalFruit(fruits1)); // Expected: 3
    }

    @Test
    void FruitIntoBaskets2(){
        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Output: " + sol.totalFruit(fruits2)); // Expected: 3
    }

    @Test
    void FruitIntoBaskets3(){
        // Example 3
        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Output: " + sol.totalFruit(fruits3)); // Expected: 4
    }

    @Test
    void FruitIntoBaskets4(){
        // Edge case: single type
        int[] fruits4 = {5, 5, 5, 5};
        System.out.println("Output: " + sol.totalFruit(fruits4)); // Expected: 4
    }

    @Test
    void FruitIntoBaskets5(){
        // Edge case: all different
        int[] fruits5 = {1, 2, 3, 4, 5};
        System.out.println("Output: " + sol.totalFruit(fruits5)); // Expected: 2
    }

    void FruitIntoBaskets6(){
        int[] fruits6 = {};
        System.out.println("Output: " + sol.totalFruit(fruits6)); // Expected: 0
    }
}
