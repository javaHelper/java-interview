package com.example.geeksforgeeks.array;

import java.util.Arrays;
import java.util.List;

public class ThirdLargest {

    public int thirdLargest(List<Integer> arr) {
        if (arr.size() < 3) {
            return -1;
        }
        int largest = 0;
        int secondLargest = 0;
        int thirdLargest = 0;

        for (int num : arr) {
            if (num > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            } else if (num > thirdLargest) {
                thirdLargest = num;
            }
        }
        return thirdLargest;
    }

    static void main() {
        ThirdLargest t = new ThirdLargest();
        System.out.println(t.thirdLargest(Arrays.asList(2, 4, 1, 3, 5)));
        System.out.println(t.thirdLargest(Arrays.asList(10, 2)));
        System.out.println(t.thirdLargest(Arrays.asList(5, 5, 5)));
    }
}
