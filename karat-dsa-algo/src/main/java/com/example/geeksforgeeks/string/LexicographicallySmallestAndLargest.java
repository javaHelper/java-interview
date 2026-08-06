package com.example.geeksforgeeks.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicallySmallestAndLargest {
    ArrayList<String> orderString(ArrayList<String> s) {
        String smallest = s.get(0);
        String largest = s.get(0);

        for (String str : s) {
            if (str.compareTo(smallest) < 0) {
                smallest = str;
            }
            if (str.compareTo(largest) > 0) {
                largest = str;
            }
        }
        ArrayList<String> result = new ArrayList<>();
        result.add(smallest);
        result.add(largest);
        return result;
    }

    static void main() {
        LexicographicallySmallestAndLargest sol = new LexicographicallySmallestAndLargest();
        System.out.println(sol.orderString(new ArrayList<>(Arrays.asList("cat", "apple", "zebra", "ball"))));
    }
}
