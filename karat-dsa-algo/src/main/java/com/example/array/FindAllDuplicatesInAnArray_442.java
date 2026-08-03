package com.example.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray_442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int num: nums){
            // Get the index corresponding to this value (1-based to 0-based)
            int index = Math.abs(num) - 1;

            // If the number at that index is already negative, it's a duplicate
            if (nums[index] < 0) {
                result.add(Math.abs(num));
            } else {
                // Mark as seen by negating the value at that index
                nums[index] = -nums[index];
            }
        }
        return result;
    }

    static void main() {
        FindAllDuplicatesInAnArray_442 f = new FindAllDuplicatesInAnArray_442();
        System.out.println(f.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }
}
