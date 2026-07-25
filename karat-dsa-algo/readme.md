# DSA Mastery Guide: Arrays, Stack & Queue
> All solutions in Java | Step-by-step explanations | Time & Space Complexity

---

# TABLE OF CONTENTS

1. [Arrays - Easy](#arrays-easy)
2. [Arrays - Medium](#arrays-medium)
3. [Arrays - Hard](#arrays-hard)
4. [Stack - Easy](#stack-easy)
5. [Stack - Medium](#stack-medium)
6. [Stack - Hard](#stack-hard)
7. [Queue / Deque - Easy](#queue-easy)
8. [Queue / Deque - Medium](#queue-medium)
9. [Queue / Deque - Hard](#queue-hard)

---

# ARRAYS - EASY

---

## 1. Two Sum (LC #1)

### Problem
Given an array of integers `nums` and an integer `target`, return indices of the two numbers that add up to target.

### Intuition
Instead of checking every pair (O(n²)), use a HashMap to store each number and its index. For each number, check if `target - number` already exists in the map.

### Step-by-Step
1. Create an empty HashMap `<Integer, Integer>` (value → index).
2. Loop through each element `nums[i]`.
3. Calculate `complement = target - nums[i]`.
4. Check if `complement` is already in the map.
    - If YES → return `{map.get(complement), i}`.
    - If NO → put `nums[i] → i` into the map.
5. Return empty array if no solution (guaranteed one solution exists).

### Java Solution
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
```

### Complexity
- **Time**: O(n) — single pass through array
- **Space**: O(n) — HashMap stores up to n elements

---

## 2. Remove Duplicates from Sorted Array (LC #26)

### Problem
Given a sorted array, remove duplicates in-place and return the count of unique elements.

### Intuition
Since the array is sorted, duplicates are adjacent. Use two pointers: a slow pointer `k` tracking the position to write the next unique element, and a fast pointer `i` scanning ahead.

### Step-by-Step
1. If array is empty, return 0.
2. Initialize `k = 1` (first element is always unique).
3. Loop `i` from index 1 to end:
    - If `nums[i] != nums[i-1]` → it's a new unique element.
        - Set `nums[k] = nums[i]`.
        - Increment `k`.
4. Return `k` (count of unique elements).

### Java Solution
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1) — in-place

---

## 3. Remove Element (LC #27)

### Problem
Remove all occurrences of `val` from the array in-place and return new length.

### Intuition
Two-pointer approach: `k` tracks where to write next valid element, `i` scans all elements. Only copy elements that are NOT equal to `val`.

### Step-by-Step
1. Initialize `k = 0`.
2. Loop `i` from 0 to end:
    - If `nums[i] != val`:
        - Set `nums[k] = nums[i]`.
        - Increment `k`.
3. Return `k`.

### Java Solution
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 4. Maximum Subarray (LC #53)

### Problem
Find the contiguous subarray with the largest sum.

### Intuition
Kadane's Algorithm: maintain a running sum. If the running sum becomes negative, reset it to 0 (start a new subarray). Track the global maximum throughout.

### Step-by-Step
1. Initialize `maxSum = nums[0]`, `currentSum = nums[0]`.
2. Loop from index 1 to end:
    - `currentSum = Math.max(nums[i], currentSum + nums[i])`.
        - This decides: extend existing subarray OR start fresh at `nums[i]`.
    - `maxSum = Math.max(maxSum, currentSum)`.
3. Return `maxSum`.

### Java Solution
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 5. Best Time to Buy and Sell Stock (LC #121)

### Problem
Given prices array, find max profit from one buy-sell transaction.

### Intuition
Track the minimum price seen so far. For each day, calculate potential profit if we sell today. Update the minimum as we go.

### Step-by-Step
1. Initialize `minPrice = Integer.MAX_VALUE`, `maxProfit = 0`.
2. Loop through each price:
    - If `price < minPrice` → update `minPrice = price`.
    - Else if `price - minPrice > maxProfit` → update `maxProfit`.
3. Return `maxProfit`.

### Java Solution
```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 6. Majority Element (LC #169)

### Problem
Find the element that appears more than n/2 times.

### Intuition
Boyer-Moore Voting: if we cancel out every occurrence of one element with a different element, the majority element survives.

### Step-by-Step
1. Initialize `candidate = nums[0]`, `count = 1`.
2. Loop from index 1:
    - If `count == 0` → set `candidate = nums[i]`, `count = 1`.
    - Else if `nums[i] == candidate` → increment `count`.
    - Else → decrement `count`.
3. Return `candidate` (guaranteed to be majority element).

### Java Solution
```java
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 7. Contains Duplicate (LC #217)

### Problem
Return true if any value appears at least twice.

### Intuition
Use a HashSet. If we try to add an element that's already present, return true.

### Step-by-Step
1. Create empty `HashSet<Integer>`.
2. For each number:
    - If set already `contains(num)` → return `true`.
    - Else `add(num)` to set.
3. Return `false` if loop completes.

### Java Solution
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) return true;
            seen.add(num);
        }
        return false;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 8. Product of Array Except Self (LC #238)

### Problem
Return array where `output[i]` = product of all elements except `nums[i]`. No division allowed.

### Intuition
Two-pass approach: first compute prefix products (product of all elements to the LEFT), then multiply by suffix products (product of all elements to the RIGHT).

### Step-by-Step
1. Create `result` array of size n.
2. **Left pass**: `result[0] = 1`. For `i` from 1 to n-1: `result[i] = result[i-1] * nums[i-1]`.
3. **Right pass**: Initialize `suffix = 1`. For `i` from n-1 to 0:
    - `result[i] *= suffix`.
    - `suffix *= nums[i]`.
4. Return `result`.

### Java Solution
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= nums[i];
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1) (output array doesn't count)

---

## 9. Move Zeroes (LC #283)

### Problem
Move all 0s to the end while maintaining relative order of non-zero elements.

### Intuition
Two-pointer: `k` points to next position for non-zero element. After placing all non-zero elements, fill remaining positions with 0.

### Step-by-Step
1. Initialize `k = 0`.
2. Loop through array: if `nums[i] != 0`, set `nums[k++] = nums[i]`.
3. After loop, fill `nums[k]` to `nums[n-1]` with 0.

### Java Solution
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 10. Find All Numbers Disappeared in Array (LC #448)

### Problem
Find all numbers in range [1, n] that do not appear in the array.

### Intuition
Use the array itself as a hash. For each value `v`, mark `nums[v-1]` as negative. After marking, indices with positive values are the missing numbers.

### Step-by-Step
1. Loop through `nums`: for each value `v = Math.abs(nums[i])`, negate `nums[v-1]` if it's positive.
2. Loop again: if `nums[i] > 0`, then `i+1` is missing → add to result list.
3. Return result list.

### Java Solution
```java
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1) (excluding output)

---

# ARRAYS - MEDIUM

---

## 11. Container With Most Water (LC #11)

### Problem
Given heights array, find two lines that form a container holding the most water.

### Intuition
Two pointers from both ends. The area = min(height[left], height[right]) * (right - left). Move the pointer with the smaller height inward (moving the taller one can never improve the area).

### Step-by-Step
1. `left = 0`, `right = n-1`, `maxArea = 0`.
2. While `left < right`:
    - `area = Math.min(heights[left], heights[right]) * (right - left)`.
    - Update `maxArea`.
    - If `heights[left] < heights[right]` → `left++`, else `right--`.
3. Return `maxArea`.

### Java Solution
```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 12. 3Sum (LC #15)

### Problem
Find all unique triplets that sum to zero.

### Intuition
Sort the array. Fix one element and use two pointers for the remaining two. Skip duplicates to avoid duplicate triplets.

### Step-by-Step
1. Sort `nums`.
2. Loop `i` from 0 to n-3:
    - Skip if `nums[i] == nums[i-1]` (duplicate).
    - Set `left = i+1`, `right = n-1`.
    - While `left < right`:
        - `sum = nums[i] + nums[left] + nums[right]`.
        - If sum == 0 → add triplet, skip duplicates for left and right, advance both pointers.
        - If sum < 0 → `left++`.
        - If sum > 0 → `right--`.
3. Return result list.

### Java Solution
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++; right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n²)
- **Space**: O(1) (excluding output)

---

## 13. Next Permutation (LC #31)

### Problem
Find the next lexicographically greater permutation in-place.

### Intuition
From the right, find the first decreasing element (the "pivot"). Then find the smallest element to its right that is still larger, swap them, then reverse the suffix after the pivot position.

### Step-by-Step
1. Find largest index `i` such that `nums[i] < nums[i+1]`. If none, reverse entire array (it's the last permutation).
2. Find largest index `j` such that `nums[j] > nums[i]`.
3. Swap `nums[i]` and `nums[j]`.
4. Reverse the suffix starting at `nums[i+1]`.

### Java Solution
```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) j--;
            int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp;
        }
        // reverse from i+1 to end
        int left = i + 1, right = n - 1;
        while (left < right) {
            int tmp = nums[left]; nums[left] = nums[right]; nums[right] = tmp;
            left++; right--;
        }
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 14. Search in Rotated Sorted Array (LC #33)

### Problem
Search for target in a rotated sorted array. Return index or -1.

### Intuition
Modified binary search. At each mid, one half is always sorted. Check which half is sorted and whether target lies in it, then eliminate the other half.

### Step-by-Step
1. `left = 0`, `right = n-1`.
2. While `left <= right`:
    - `mid = (left + right) / 2`.
    - If `nums[mid] == target` → return `mid`.
    - If left half is sorted (`nums[left] <= nums[mid]`):
        - If target is in left half → `right = mid - 1`.
        - Else → `left = mid + 1`.
    - Else (right half is sorted):
        - If target is in right half → `left = mid + 1`.
        - Else → `right = mid - 1`.
3. Return -1.

### Java Solution
```java
class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
```

### Complexity
- **Time**: O(log n)
- **Space**: O(1)

---

## 15. Find First and Last Position (LC #34)

### Problem
Find starting and ending position of a target in a sorted array.

### Intuition
Two binary searches: one to find the leftmost occurrence, one for the rightmost.

### Step-by-Step
1. **findFirst**: Binary search, when `nums[mid] == target`, save position and continue searching left (`right = mid - 1`).
2. **findLast**: Binary search, when `nums[mid] == target`, save position and continue searching right (`left = mid + 1`).
3. Return `[first, last]`.

### Java Solution
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findBound(nums, target, true), findBound(nums, target, false)};
    }
    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1, bound = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                bound = mid;
                if (isFirst) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return bound;
    }
}
```

### Complexity
- **Time**: O(log n)
- **Space**: O(1)

---

## 16. Combination Sum (LC #39)

### Problem
Find all combinations of candidates that sum to target (can reuse elements).

### Intuition
Backtracking: at each step, choose to include the current element (and stay at same index since reuse is allowed) or skip to next.

### Step-by-Step
1. Sort candidates (optional but helps with pruning).
2. Recursive function `backtrack(start, remaining, current)`:
    - If `remaining == 0` → add copy of `current` to result.
    - Loop from `start` to end:
        - If `candidates[i] > remaining` → break (pruning).
        - Add `candidates[i]`, recurse with `backtrack(i, remaining - candidates[i], current)`.
        - Remove last element (backtrack).

### Java Solution
```java
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(int[] candidates, int remaining, int start,
                           List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;
            current.add(candidates[i]);
            backtrack(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
```

### Complexity
- **Time**: O(n^(T/M)) where T=target, M=min candidate
- **Space**: O(T/M) recursion depth

---

## 17. Rotate Image (LC #48)

### Problem
Rotate an n×n matrix 90 degrees clockwise in-place.

### Intuition
Clockwise 90° rotation = Transpose + Reverse each row.

### Step-by-Step
1. **Transpose**: Swap `matrix[i][j]` with `matrix[j][i]` for all `i < j`.
2. **Reverse each row**: For each row, reverse it in-place.

### Java Solution
```java
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++; right--;
            }
        }
    }
}
```

### Complexity
- **Time**: O(n²)
- **Space**: O(1)

---

## 18. Merge Intervals (LC #56)

### Problem
Merge all overlapping intervals.

### Intuition
Sort intervals by start time. Then linearly scan — if current interval overlaps with previous (current start <= prev end), merge by extending the end.

### Step-by-Step
1. Sort `intervals` by `intervals[i][0]`.
2. Add first interval to result list.
3. For each subsequent interval:
    - If `interval[0] <= last.end` → overlap → update `last.end = max(last.end, interval[1])`.
    - Else → no overlap → add interval to result.
4. Convert result list to array.

### Java Solution
```java
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = result.get(result.size() - 1);
            if (intervals[i][0] <= last[1]) {
                last[1] = Math.max(last[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[0][]);
    }
}
```

### Complexity
- **Time**: O(n log n)
- **Space**: O(n)

---

## 19. Sort Colors (LC #75)

### Problem
Sort array containing 0s, 1s, and 2s in-place (Dutch National Flag).

### Intuition
Three pointers: `low` (boundary of 0s), `mid` (current element), `high` (boundary of 2s). Swap elements to their correct zones.

### Step-by-Step
1. `low = 0`, `mid = 0`, `high = n-1`.
2. While `mid <= high`:
    - If `nums[mid] == 0` → swap with `nums[low]`, `low++`, `mid++`.
    - If `nums[mid] == 1` → `mid++`.
    - If `nums[mid] == 2` → swap with `nums[high]`, `high--` (don't increment mid — new element at mid needs checking).

### Java Solution
```java
class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int tmp = nums[low]; nums[low] = nums[mid]; nums[mid] = tmp;
                low++; mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int tmp = nums[mid]; nums[mid] = nums[high]; nums[high] = tmp;
                high--;
            }
        }
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 20. Maximum Product Subarray (LC #152)

### Problem
Find the contiguous subarray with the maximum product.

### Intuition
Unlike sum, products can flip sign with negatives. Track both the current max AND min product (a min can become max when multiplied by a negative).

### Step-by-Step
1. `maxProd = nums[0]`, `minProd = nums[0]`, `result = nums[0]`.
2. For each element from index 1:
    - If `nums[i] < 0` → swap `maxProd` and `minProd` (because multiplying by negative flips them).
    - `maxProd = Math.max(nums[i], maxProd * nums[i])`.
    - `minProd = Math.min(nums[i], minProd * nums[i])`.
    - Update `result`.

### Java Solution
```java
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0], minProd = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = maxProd; maxProd = minProd; minProd = tmp;
            }
            maxProd = Math.max(nums[i], maxProd * nums[i]);
            minProd = Math.min(nums[i], minProd * nums[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 21. Find Minimum in Rotated Sorted Array (LC #153)

### Problem
Find the minimum element in a rotated sorted array.

### Intuition
Binary search: the minimum is in the unsorted half. If `nums[mid] > nums[right]`, the minimum is in the right half. Otherwise it's in the left half (including mid).

### Step-by-Step
1. `left = 0`, `right = n-1`.
2. While `left < right`:
    - `mid = (left + right) / 2`.
    - If `nums[mid] > nums[right]` → min is in right half → `left = mid + 1`.
    - Else → min is in left half (including mid) → `right = mid`.
3. Return `nums[left]`.

### Java Solution
```java
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
```

### Complexity
- **Time**: O(log n)
- **Space**: O(1)

---

## 22. Rotate Array (LC #189)

### Problem
Rotate array to the right by k steps.

### Intuition
Reversal trick: reverse entire array → reverse first k elements → reverse remaining n-k elements.

### Step-by-Step
1. `k = k % n` (handle k > n).
2. Reverse entire array.
3. Reverse `nums[0..k-1]`.
4. Reverse `nums[k..n-1]`.

### Java Solution
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int tmp = nums[left]; nums[left] = nums[right]; nums[right] = tmp;
            left++; right--;
        }
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 23. Majority Element II (LC #229)

### Problem
Find all elements that appear more than n/3 times.

### Intuition
At most 2 such elements can exist. Extended Boyer-Moore: maintain two candidates and their counts.

### Step-by-Step
1. Two candidates `cand1`, `cand2` and counts `count1 = 0`, `count2 = 0`.
2. For each num:
    - If `num == cand1` → `count1++`.
    - Else if `num == cand2` → `count2++`.
    - Else if `count1 == 0` → `cand1 = num`, `count1 = 1`.
    - Else if `count2 == 0` → `cand2 = num`, `count2 = 1`.
    - Else → `count1--`, `count2--`.
3. Verify both candidates by counting occurrences and checking > n/3.

### Java Solution
```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = 0, cand2 = 1, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
            else if (count1 == 0) { cand1 = num; count1 = 1; }
            else if (count2 == 0) { cand2 = num; count2 = 1; }
            else { count1--; count2--; }
        }
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == cand1) count1++;
            else if (num == cand2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(cand1);
        if (count2 > nums.length / 3) result.add(cand2);
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 24. Find the Duplicate Number (LC #287)

### Problem
Find the duplicate number in array of n+1 integers (values 1 to n). No extra space allowed.

### Intuition
Floyd's Cycle Detection (like linked list cycle). Treat array values as "next pointers". The duplicate creates a cycle entry point.

### Step-by-Step
1. **Phase 1 — Find intersection**: `slow = nums[0]`, `fast = nums[0]`. Move slow by 1 step, fast by 2 steps until they meet.
2. **Phase 2 — Find cycle start**: Reset one pointer to `nums[0]`. Move both one step at a time. Where they meet is the duplicate.

### Java Solution
```java
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        // Phase 1
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Phase 2
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 25. Subarray Sum Equals K (LC #560)

### Problem
Count total number of subarrays that sum to k.

### Intuition
Prefix sum + HashMap. If `prefixSum[j] - prefixSum[i] == k`, then subarray `[i+1..j]` sums to k. So for each prefix sum, check how many previous prefix sums equal `currentSum - k`.

### Step-by-Step
1. `map = {0: 1}` (empty subarray has sum 0).
2. `currentSum = 0`, `count = 0`.
3. For each num:
    - `currentSum += num`.
    - If `map.containsKey(currentSum - k)` → `count += map.get(currentSum - k)`.
    - Update `map.put(currentSum, map.getOrDefault(currentSum, 0) + 1)`.
4. Return `count`.

### Java Solution
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int currentSum = 0, count = 0;
        for (int num : nums) {
            currentSum += num;
            count += map.getOrDefault(currentSum - k, 0);
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# ARRAYS - HARD

---

## 26. Median of Two Sorted Arrays (LC #4)

### Problem
Find the median of two sorted arrays in O(log(m+n)) time.

### Intuition
Binary search on the smaller array. Partition both arrays such that left halves combined = right halves combined. The median is at the partition boundary.

### Step-by-Step
1. Ensure `nums1` is the smaller array.
2. Binary search on `nums1` partition `x` (0 to m).
3. Derive `nums2` partition `y = (m + n + 1) / 2 - x`.
4. Check: `maxLeft1 <= minRight2` AND `maxLeft2 <= minRight1`.
    - If valid → found partition → compute median.
    - If `maxLeft1 > minRight2` → move left → `high = x - 1`.
    - Else → move right → `low = x + 1`.

### Java Solution
```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m = nums1.length, n = nums2.length;
        int low = 0, high = m;
        while (low <= high) {
            int x = (low + high) / 2;
            int y = (m + n + 1) / 2 - x;
            int maxLeft1 = (x == 0) ? Integer.MIN_VALUE : nums1[x - 1];
            int minRight1 = (x == m) ? Integer.MAX_VALUE : nums1[x];
            int maxLeft2 = (y == 0) ? Integer.MIN_VALUE : nums2[y - 1];
            int minRight2 = (y == n) ? Integer.MAX_VALUE : nums2[y];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if ((m + n) % 2 == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                else
                    return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2) {
                high = x - 1;
            } else {
                low = x + 1;
            }
        }
        return 0.0;
    }
}
```

### Complexity
- **Time**: O(log(min(m,n)))
- **Space**: O(1)

---

## 27. First Missing Positive (LC #41)

### Problem
Find the smallest missing positive integer in O(n) time and O(1) space.

### Intuition
The answer must be in range [1, n+1]. Use the array as a hash table: place each number x in index x-1. Then scan for first position where nums[i] != i+1.

### Step-by-Step
1. For each number, if it's in range [1, n] and not already in correct position, swap it to `nums[nums[i]-1]`. Repeat until no more swaps needed.
2. Scan array: first `i` where `nums[i] != i+1` → return `i+1`.
3. If all positions correct, return `n+1`.

### Java Solution
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 28. Trapping Rain Water (LC #42)

### Problem
Given heights, calculate how much rainwater can be trapped.

### Intuition
Water at position i = `min(maxLeft[i], maxRight[i]) - height[i]`. Use two pointers to avoid extra arrays: whichever side has the smaller max, process that side.

### Step-by-Step
1. `left = 0`, `right = n-1`, `leftMax = 0`, `rightMax = 0`, `water = 0`.
2. While `left < right`:
    - If `height[left] <= height[right]`:
        - If `height[left] >= leftMax` → update `leftMax`.
        - Else → `water += leftMax - height[left]`.
        - `left++`.
    - Else (mirror for right side).
3. Return `water`.

### Java Solution
```java
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, water = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else water += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else water += rightMax - height[right];
                right--;
            }
        }
        return water;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1)

---

## 29. Largest Rectangle in Histogram (LC #84)

### Problem
Find the largest rectangle in a histogram.

### Intuition
Monotonic stack: maintain a stack of bar indices in increasing height order. When a bar shorter than the top is encountered, pop and calculate the rectangle area using that height.

### Step-by-Step
1. Create stack. Append sentinel height 0 at end.
2. For each bar (including sentinel):
    - While stack not empty and `heights[i] < heights[stack.peek()]`:
        - Pop height index `h`.
        - Width = `stack.isEmpty() ? i : i - stack.peek() - 1`.
        - Update `maxArea`.
    - Push `i`.
3. Return `maxArea`.

### Java Solution
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] h = Arrays.copyOf(heights, n + 1); // sentinel 0 at end
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 30. Sliding Window Maximum (LC #239)

### Problem
Return max of every sliding window of size k.

### Intuition
Monotonic Deque (decreasing): maintain a deque of indices where values are in decreasing order. Front always holds the current window maximum.

### Step-by-Step
1. Create `ArrayDeque<Integer>` deque and result array.
2. For each index `i`:
    - Remove indices out of window from front: while `deque.peek() < i - k + 1` → `pollFirst()`.
    - Remove smaller elements from back: while `!deque.isEmpty() && nums[deque.peekLast()] < nums[i]` → `pollLast()`.
    - Add `i` to back.
    - If `i >= k-1` → `result[i-k+1] = nums[deque.peek()]`.
3. Return result.

### Java Solution
```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) deque.pollFirst();
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) deque.pollLast();
            deque.addLast(i);
            if (i >= k - 1) result[i - k + 1] = nums[deque.peek()];
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(k)

---

# STACK - EASY

---

## 31. Valid Parentheses (LC #20)

### Problem
Determine if brackets are valid (each open bracket closed in correct order).

### Intuition
Use a stack. Push opening brackets. For closing brackets, check if top of stack matches.

### Step-by-Step
1. Create stack.
2. For each character:
    - If `(`, `[`, or `{` → push.
    - If `)`, `]`, or `}`:
        - If stack empty or top doesn't match → return `false`.
        - Else pop.
3. Return `stack.isEmpty()`.

### Java Solution
```java
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        return stack.isEmpty();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 32. Min Stack (LC #155)

### Problem
Design a stack that supports push, pop, top, and getMin in O(1).

### Intuition
Maintain a secondary stack that tracks the current minimum at each level. When pushing, push the min of new value and current min to the min stack.

### Step-by-Step
1. Two stacks: `stack` and `minStack`.
2. **push(val)**: push `val` to stack. Push `min(val, minStack.top)` to minStack.
3. **pop()**: pop from both stacks.
4. **top()**: return `stack.peek()`.
5. **getMin()**: return `minStack.peek()`.

### Java Solution
```java
class MinStack {
    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        minStack.push(minStack.isEmpty() ? val : Math.min(val, minStack.peek()));
    }
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    public int top() { return stack.peek(); }
    public int getMin() { return minStack.peek(); }
}
```

### Complexity
- **Time**: O(1) for all operations
- **Space**: O(n)

---

## 33. Implement Stack using Queues (LC #225)

### Problem
Implement a stack using only queue operations.

### Intuition
Use one queue. On every push, rotate all previous elements to the back (making new element the front).

### Step-by-Step
1. Use `Queue<Integer>`.
2. **push(x)**: add x to queue, then rotate all elements before x to back (poll and offer n-1 times).
3. **pop()**: poll from front.
4. **top()**: peek at front.

### Java Solution
```java
class MyStack {
    private Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }
    public int pop() { return queue.poll(); }
    public int top() { return queue.peek(); }
    public boolean empty() { return queue.isEmpty(); }
}
```

### Complexity
- **Push Time**: O(n) | **Pop/Top**: O(1)

---

## 34. Implement Queue using Stacks (LC #232)

### Problem
Implement a queue using only stack operations.

### Intuition
Two stacks: `inStack` for pushes and `outStack` for pops. Transfer elements from inStack to outStack lazily when outStack is empty.

### Step-by-Step
1. **push(x)**: push to `inStack`.
2. **pop()**:
    - If `outStack` empty → transfer all from `inStack` to `outStack`.
    - Pop from `outStack`.
3. **peek()**: similar to pop but don't remove.

### Java Solution
```java
class MyQueue {
    private Deque<Integer> inStack = new ArrayDeque<>();
    private Deque<Integer> outStack = new ArrayDeque<>();

    public void push(int x) { inStack.push(x); }
    public int pop() {
        transfer();
        return outStack.pop();
    }
    public int peek() {
        transfer();
        return outStack.peek();
    }
    private void transfer() {
        if (outStack.isEmpty())
            while (!inStack.isEmpty()) outStack.push(inStack.pop());
    }
    public boolean empty() { return inStack.isEmpty() && outStack.isEmpty(); }
}
```

### Complexity
- **Amortized**: O(1) per operation

---

## 35. Baseball Game (LC #682)

### Problem
Calculate baseball game score with ops: integer (add score), `+` (sum of last two), `D` (double last), `C` (invalidate last).

### Intuition
Use a stack to track valid scores. Each operation modifies the stack accordingly.

### Step-by-Step
1. Create stack.
2. For each op:
    - Digit → push `Integer.parseInt(op)`.
    - `"+"` → push `stack[top] + stack[top-1]`.
    - `"D"` → push `stack[top] * 2`.
    - `"C"` → pop.
3. Sum all elements in stack.

### Java Solution
```java
class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 36. Remove All Adjacent Duplicates (LC #1047)

### Problem
Repeatedly remove adjacent duplicate letters.

### Intuition
Use a stack. For each character, if it matches the top of the stack, pop (they cancel out). Otherwise push.

### Step-by-Step
1. Create stack.
2. For each character `c`:
    - If stack not empty and `stack.peek() == c` → pop.
    - Else push `c`.
3. Build result string from stack (in order).

### Java Solution
```java
class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# STACK - MEDIUM

---

## 37. Simplify Path (LC #71)

### Problem
Simplify a Unix file path (handle `.`, `..`, multiple slashes).

### Intuition
Split path by `/`. Use a stack/deque for directory names. `..` pops the last directory. `.` and empty strings are ignored.

### Step-by-Step
1. Split path by `"/"`.
2. For each part:
    - Skip if empty or `"."`.
    - If `".."` → pop if stack not empty.
    - Else push part.
3. Join stack contents with `"/"` prefix.

### Java Solution
```java
class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!part.isEmpty() && !part.equals(".")) {
                stack.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) sb.insert(0, "/" + dir);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 38. Evaluate Reverse Polish Notation (LC #150)

### Problem
Evaluate an expression in Reverse Polish Notation (postfix).

### Intuition
Push numbers onto stack. When encountering an operator, pop two operands, apply operator, push result.

### Step-by-Step
1. For each token:
    - If number → push.
    - If operator (`+`, `-`, `*`, `/`) → pop `b` then `a`, compute `a op b`, push result.
2. Return top of stack.

### Java Solution
```java
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+": stack.push(stack.pop() + stack.pop()); break;
                case "-": { int b = stack.pop(), a = stack.pop(); stack.push(a - b); break; }
                case "*": stack.push(stack.pop() * stack.pop()); break;
                case "/": { int b = stack.pop(), a = stack.pop(); stack.push(a / b); break; }
                default: stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 39. Decode String (LC #394)

### Problem
Decode a string encoded as `k[encoded_string]` where `k` is repeat count.

### Intuition
Two stacks: one for counts, one for strings. On `[`, save current state. On `]`, pop and build repeated string.

### Step-by-Step
1. Stack of counts and stack of strings.
2. Current string `curr = ""`, current number `k = 0`.
3. For each character:
    - Digit → `k = k * 10 + digit`.
    - `[` → push `k` and `curr` to their stacks, reset both.
    - `]` → pop count `n` and prev string `s`, set `curr = s + curr.repeat(n)`.
    - Letter → append to `curr`.
4. Return `curr`.

### Java Solution
```java
class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(curr.toString());
                curr = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                int count = countStack.pop();
                String prev = stringStack.pop();
                StringBuilder repeated = new StringBuilder(prev);
                for (int i = 0; i < count; i++) repeated.append(curr);
                curr = repeated;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
```

### Complexity
- **Time**: O(max_k * n)
- **Space**: O(n)

---

## 40. Remove K Digits (LC #402)

### Problem
Remove k digits to make the smallest possible number.

### Intuition
Monotonic stack (increasing): if current digit is smaller than top of stack, pop the top (it's a larger digit that should be removed). This greedily gives the smallest number.

### Step-by-Step
1. Use a deque as stack.
2. For each digit:
    - While `k > 0` and stack not empty and `stack.peek() > digit` → pop, `k--`.
    - Push digit.
3. If `k > 0` still → remove last k digits.
4. Build result skipping leading zeros.
5. Return `"0"` if empty.

### Java Solution
```java
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop(); k--;
            }
            stack.push(c);
        }
        while (k-- > 0) stack.pop();
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (char c : stack) { // iterate bottom to top using descendingIterator workaround
        }
        // Rebuild correctly
        Deque<Character> result = new ArrayDeque<>();
        while (!stack.isEmpty()) result.push(stack.pop());
        StringBuilder res = new StringBuilder();
        boolean leading = true;
        while (!result.isEmpty()) {
            char c = result.pop();
            if (leading && c == '0') continue;
            leading = false;
            res.append(c);
        }
        return res.length() == 0 ? "0" : res.toString();
    }
}
```

### Cleaner Java Solution
```java
class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        while (k-- > 0) sb.deleteCharAt(sb.length() - 1);
        int start = 0;
        while (start < sb.length() - 1 && sb.charAt(start) == '0') start++;
        return sb.substring(start);
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 41. Daily Temperatures (LC #739)

### Problem
For each day, find how many days until a warmer temperature.

### Intuition
Monotonic stack (decreasing): when a warmer temperature is found, pop all cooler days from the stack and record the answer as the difference in indices.

### Step-by-Step
1. `result` array of size n. Stack stores indices.
2. For each day `i`:
    - While stack not empty and `temperatures[i] > temperatures[stack.peek()]`:
        - Pop index `j`.
        - `result[j] = i - j`.
    - Push `i`.
3. Remaining in stack → answer is 0 (default).

### Java Solution
```java
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 42. Next Greater Element I (LC #496)

### Problem
For each element in `nums1`, find next greater element in `nums2`.

### Intuition
Preprocess `nums2` with monotonic stack: for each element, find its next greater. Store in HashMap. Then look up each element in `nums1`.

### Step-by-Step
1. Process `nums2` with decreasing monotonic stack:
    - While stack not empty and `nums2[i] > stack.peek()` → pop, map `popped → nums2[i]`.
    - Push `nums2[i]`.
2. For each num in `nums1`, look up in map (default -1).

### Java Solution
```java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(m + n)
- **Space**: O(n)

---

## 43. Next Greater Element II (LC #503)

### Problem
Circular array — find next greater element wrapping around.

### Intuition
Same monotonic stack, but iterate through the array twice (using `i % n`) to simulate the circular wrap.

### Step-by-Step
1. `result` array filled with -1. Stack of indices.
2. Loop `i` from 0 to `2n-1`:
    - `idx = i % n`.
    - While stack not empty and `nums[idx] > nums[stack.peek()]` → pop `j`, `result[j] = nums[idx]`.
    - Push `idx` only for first pass (`i < n`).
3. Return result.

### Java Solution
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % n];
            }
            if (i < n) stack.push(i);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 44. Car Fleet (LC #853)

### Problem
Cars travel to target. Cars that catch up form a fleet. Count number of fleets.

### Intuition
Sort cars by position (closest to target first). Compute time to reach target for each. A car forms a new fleet if it takes longer than the car ahead (it can't catch up). Use a stack.

### Step-by-Step
1. Create array of `[position, time]` pairs, sort by position descending.
2. Stack tracks fleet times.
3. For each car's time:
    - If stack empty or time > stack top → push (new fleet).
    - Else → it merges with fleet ahead.
4. Return stack size.

### Java Solution
```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        Deque<Double> stack = new ArrayDeque<>();
        for (double[] car : cars) {
            if (stack.isEmpty() || car[1] > stack.peek()) {
                stack.push(car[1]);
            }
        }
        return stack.size();
    }
}
```

### Complexity
- **Time**: O(n log n)
- **Space**: O(n)

---

## 45. Remove All Adjacent Duplicates II (LC #1209)

### Problem
Remove k adjacent duplicate letters repeatedly.

### Intuition
Stack stores `[character, count]` pairs. When count reaches k, pop the entry.

### Step-by-Step
1. Stack of `int[]` where `[0]` = char code, `[1]` = count.
2. For each character:
    - If stack not empty and top char == current → increment count.
    - Else push `[c, 1]`.
    - If top count == k → pop.
3. Build result from stack.

### Java Solution
```java
class Solution {
    public String removeDuplicates(String s, int k) {
        Deque<int[]> stack = new ArrayDeque<>(); // [char, count]
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                stack.peek()[1]++;
                if (stack.peek()[1] == k) stack.pop();
            } else {
                stack.push(new int[]{c, 1});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            int[] top = stack.pop();
            for (int i = 0; i < top[1]; i++) sb.append((char) top[0]);
        }
        return sb.reverse().toString();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# STACK - HARD

---

## 46. Maximal Rectangle (LC #85)

### Problem
Find the largest rectangle containing only 1s in a binary matrix.

### Intuition
For each row, build a histogram of heights (consecutive 1s). Then apply "Largest Rectangle in Histogram" (LC #84) on each row's histogram.

### Step-by-Step
1. Initialize `heights` array of size n (columns) with 0s.
2. For each row:
    - Update `heights[j]`: if `matrix[i][j] == '1'` → `heights[j]++`, else `heights[j] = 0`.
    - Run LC #84 on `heights`, update global max.
3. Return max area.

### Java Solution
```java
class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestInHistogram(heights));
        }
        return maxArea;
    }
    private int largestInHistogram(int[] heights) {
        int n = heights.length, maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
```

### Complexity
- **Time**: O(m × n)
- **Space**: O(n)

---

## 47. Basic Calculator (LC #224)

### Problem
Evaluate a string expression with `+`, `-`, `(`, `)` and spaces.

### Intuition
Track current number and running result. Use a stack to save `[result, sign]` when opening a parenthesis, and restore when closing.

### Step-by-Step
1. `result = 0`, `num = 0`, `sign = 1`. Stack.
2. For each character:
    - Digit → build `num`.
    - `+` or `-` → `result += sign * num`, reset `num`, update `sign`.
    - `(` → push `result` and `sign`, reset both.
    - `)` → `result += sign * num`, then `result = result * stack.pop() + stack.pop()`, reset `num`.
3. Return `result + sign * num`.

### Java Solution
```java
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0, num = 0, sign = 1;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num; num = 0; sign = 1;
            } else if (c == '-') {
                result += sign * num; num = 0; sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0; sign = 1;
            } else if (c == ')') {
                result += sign * num; num = 0;
                result *= stack.pop(); // sign before (
                result += stack.pop(); // result before (
            }
        }
        return result + sign * num;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

## 48. Remove Duplicate Letters (LC #316)

### Problem
Remove duplicate letters to get the smallest lexicographic result where each letter appears once.

### Intuition
Monotonic stack (greedy): if current char is smaller than stack top AND the top char appears again later, pop it. Use a "seen" set to avoid re-adding characters already in stack.

### Step-by-Step
1. Count remaining occurrences of each character.
2. Set `inStack` to track characters in result.
3. For each character:
    - Decrement count.
    - If already in stack → skip.
    - While stack not empty, top > current, and `count[top] > 0` (appears later) → pop, mark as not in stack.
    - Push current, mark as in stack.
4. Return stack contents as string.

### Java Solution
```java
class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (inStack[c - 'a']) continue;
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(1) — 26 letter alphabet

---

## 49. Minimum Cost Tree From Leaf Values (LC #1130)

### Problem
Build a BST from leaf values with minimum cost (cost = product of max leaves of left/right subtrees).

### Intuition
Monotonic stack: remove the smallest element by pairing it with the smaller of its two neighbors. This is equivalent to maintaining a decreasing stack and computing costs when popping.

### Step-by-Step
1. Stack, push `Integer.MAX_VALUE` as sentinel.
2. For each value:
    - While `stack.peek() <= value`:
        - Pop `mid`.
        - Cost += `mid * min(stack.peek(), value)`.
    - Push value.
3. While stack size > 2 (sentinel + one remaining):
    - Pop `mid`, cost += `mid * stack.peek()`.
4. Return cost.

### Java Solution
```java
class Solution {
    public int mctFromLeafValues(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.MAX_VALUE);
        int cost = 0;
        for (int val : arr) {
            while (stack.peek() <= val) {
                int mid = stack.pop();
                cost += mid * Math.min(stack.peek(), val);
            }
            stack.push(val);
        }
        while (stack.size() > 2) {
            int mid = stack.pop();
            cost += mid * stack.peek();
        }
        return cost;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# QUEUE - EASY

---

## 50. Moving Average from Data Stream (LC #346)

### Problem
Calculate moving average of last k numbers from a data stream.

### Intuition
Use a Queue of fixed size k. Track running sum. When queue is full, remove oldest and subtract from sum.

### Step-by-Step
1. `Queue<Integer>`, `size k`, `sum = 0`.
2. For each `val`:
    - If queue size == k → subtract `queue.poll()` from sum.
    - Add `val` to queue and sum.
    - Return `sum / queue.size()`.

### Java Solution
```java
class MovingAverage {
    private Queue<Integer> queue;
    private int size;
    private double sum;

    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
        sum = 0;
    }
    public double next(int val) {
        if (queue.size() == size) sum -= queue.poll();
        queue.offer(val);
        sum += val;
        return sum / queue.size();
    }
}
```

### Complexity
- **Time**: O(1) per call
- **Space**: O(k)

---

## 51. Number of Recent Calls (LC #933)

### Problem
Count calls in the last 3000ms (ping requests).

### Intuition
Use a Queue. Add each new time. Remove all entries that are older than `t - 3000`. Queue size is the answer.

### Step-by-Step
1. `Queue<Integer>`.
2. On `ping(t)`:
    - Offer `t`.
    - While `queue.peek() < t - 3000` → poll.
    - Return `queue.size()`.

### Java Solution
```java
class RecentCounter {
    private Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) queue.poll();
        return queue.size();
    }
}
```

### Complexity
- **Time**: O(1) amortized
- **Space**: O(3000) = O(1)

---

# QUEUE - MEDIUM

---

## 52. Task Scheduler (LC #621)

### Problem
Schedule tasks with cooldown `n` between same tasks. Find minimum intervals needed.

### Intuition
Always schedule the most frequent task first. Use a max-heap for tasks and a cooldown queue. If no task available (all in cooldown), idle.

### Step-by-Step
1. Count task frequencies. Build max-heap.
2. Queue tracks `[count, availableTime]`.
3. `time = 0`. While heap or queue not empty:
    - `time++`.
    - If heap not empty → pop most frequent, decrement count, if count > 0 → add to queue with `[count, time + n]`.
    - If queue front is available (`queue[0][1] == time`) → push back to heap.
4. Return `time`.

### Java Solution
```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) maxHeap.offer(f);
        Queue<int[]> cooldown = new LinkedList<>(); // [count, available time]
        int time = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int cnt = maxHeap.poll() - 1;
                if (cnt > 0) cooldown.offer(new int[]{cnt, time + n});
            }
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }
        return time;
    }
}
```

### Complexity
- **Time**: O(n log 26) = O(n)
- **Space**: O(1)

---

## 53. Design Circular Deque (LC #641)

### Problem
Design a circular double-ended queue with fixed capacity.

### Intuition
Use an array with front and rear pointers. Circular indexing using modulo.

### Step-by-Step
1. Array `data[k]`, `front = 0`, `rear = 0`, `size = 0`, `capacity = k`.
2. **insertFront(val)**: `front = (front - 1 + k) % k`, `data[front] = val`, `size++`.
3. **insertLast(val)**: `data[rear] = val`, `rear = (rear + 1) % k`, `size++`.
4. **deleteFront**: `front = (front + 1) % k`, `size--`.
5. **deleteLast**: `rear = (rear - 1 + k) % k`, `size--`.

### Java Solution
```java
class MyCircularDeque {
    private int[] data;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        capacity = k; data = new int[k]; front = 0; rear = 0; size = 0;
    }
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        data[front] = value; size++; return true;
    }
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value; rear = (rear + 1) % capacity; size++; return true;
    }
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity; size--; return true;
    }
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity; size--; return true;
    }
    public int getFront() { return isEmpty() ? -1 : data[front]; }
    public int getRear() { return isEmpty() ? -1 : data[(rear - 1 + capacity) % capacity]; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }
}
```

### Complexity
- **Time**: O(1) per operation
- **Space**: O(k)

---

## 54. Reveal Cards In Increasing Order (LC #950)

### Problem
Arrange cards so that revealing with the deck's alternating take/move-to-bottom process results in sorted order.

### Intuition
Simulate in reverse. Sort the deck. Use a deque representing final deck positions. Move last index to front (reverse of "move to bottom"), assign the next largest card to front index.

### Step-by-Step
1. Sort deck descending.
2. `Deque<Integer>` of indices 0 to n-1.
3. For each card (largest to smallest):
    - Move last index to front (reverse of send-to-back).
    - Pop from front, assign card to that index.
4. Return result array.

### Java Solution
```java
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) deque.addLast(i);
        int[] result = new int[n];
        for (int card : deck) {
            result[deque.pollFirst()] = card;
            if (!deque.isEmpty()) deque.addLast(deque.pollFirst());
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n log n)
- **Space**: O(n)

---

## 55. Longest Subarray with Abs Diff <= Limit (LC #1438)

### Problem
Find the longest subarray where max - min <= limit.

### Intuition
Sliding window + two monotonic deques (one for max, one for min). If `maxDeque.front - minDeque.front > limit`, shrink window from left.

### Step-by-Step
1. `maxDeque` (decreasing), `minDeque` (increasing). `left = 0`, `result = 0`.
2. For each `right`:
    - Maintain maxDeque (pop smaller from back before pushing right).
    - Maintain minDeque (pop larger from back before pushing right).
    - While `maxDeque.peekFirst() - minDeque.peekFirst() > limit`:
        - If `maxDeque.peekFirst() == nums[left]` → pollFirst maxDeque.
        - If `minDeque.peekFirst() == nums[left]` → pollFirst minDeque.
        - `left++`.
    - `result = max(result, right - left + 1)`.

### Java Solution
```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>(); // stores indices, values decreasing
        Deque<Integer> minDeque = new ArrayDeque<>(); // stores indices, values increasing
        int left = 0, result = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) maxDeque.pollLast();
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) minDeque.pollLast();
            maxDeque.addLast(right);
            minDeque.addLast(right);
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# QUEUE - HARD

---

## 56. Merge K Sorted Lists (LC #23)

### Problem
Merge k sorted linked lists into one sorted list.

### Intuition
Min-heap (priority queue): always extract the smallest current element. Add the next node from that list.

### Step-by-Step
1. Add head of each list to min-heap (sorted by node value).
2. While heap not empty:
    - Poll minimum node, append to result.
    - If polled node has next → push next to heap.
3. Return dummy.next.

### Java Solution
```java
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
        ListNode dummy = new ListNode(0), curr = dummy;
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;
            if (node.next != null) pq.offer(node.next);
        }
        return dummy.next;
    }
}
```

### Complexity
- **Time**: O(N log k) where N = total nodes, k = number of lists
- **Space**: O(k)

---

## 57. Find Median from Data Stream (LC #295)

### Problem
Continuously add numbers and find the median efficiently.

### Intuition
Two heaps: `maxHeap` (lower half) and `minHeap` (upper half). Balance them so their sizes differ by at most 1. Median is at the top(s).

### Step-by-Step
1. `maxHeap` = max-heap, `minHeap` = min-heap.
2. **addNum(num)**:
    - Add to `maxHeap`.
    - Move `maxHeap.top` to `minHeap` (ensure balance).
    - If `minHeap.size > maxHeap.size` → move `minHeap.top` back.
3. **findMedian()**:
    - If equal sizes → `(maxHeap.top + minHeap.top) / 2.0`.
    - Else → `maxHeap.top`.

### Java Solution
```java
class MedianFinder {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
    }
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return maxHeap.peek();
    }
}
```

### Complexity
- **addNum Time**: O(log n)
- **findMedian Time**: O(1)
- **Space**: O(n)

---

## 58. Shortest Subarray with Sum >= K (LC #862)

### Problem
Find the shortest subarray with sum >= k (array can have negative numbers).

### Intuition
Prefix sums + Monotonic Deque. For each right index, find the largest left index where `prefixSum[right] - prefixSum[left] >= k`. Deque stores indices in increasing order of prefix sum.

### Step-by-Step
1. Compute `prefix[0..n]` (prefix[0] = 0).
2. Monotonic deque of indices (increasing prefix sums).
3. For each `i` from 0 to n:
    - While deque not empty and `prefix[i] - prefix[deque.front] >= k`:
        - Update `result = min(result, i - deque.pollFirst())`.
    - While deque not empty and `prefix[i] <= prefix[deque.back]`:
        - `pollLast()` (maintain increasing order).
    - Add `i` to deque back.
4. Return `result` (or -1 if not found).

### Java Solution
```java
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];
        Deque<Integer> deque = new ArrayDeque<>();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                result = Math.min(result, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
```

### Complexity
- **Time**: O(n)
- **Space**: O(n)

---

# QUICK REFERENCE — PATTERNS CHEATSHEET

## Array Patterns
| Pattern | When to Use | Key Idea |
|---------|------------|---------|
| Two Pointers | Sorted array, palindrome, pairs | left/right move inward |
| Sliding Window | Subarray with constraint | expand right, shrink left |
| Prefix Sum | Subarray sum queries | precompute cumulative sums |
| Binary Search | Sorted array search | eliminate half each step |
| Kadane's | Max subarray sum | reset on negative running sum |
| Dutch National Flag | 3-way partition | 3 pointers: low, mid, high |
| Boyer-Moore | Majority element | cancel out votes |
| Cyclic Sort | Range [1,n] problems | place each number at index val-1 |

## Stack Patterns
| Pattern | When to Use | Key Idea |
|---------|------------|---------|
| Monotonic Increasing Stack | Next smaller element | pop when current < top |
| Monotonic Decreasing Stack | Next greater element | pop when current > top |
| Two Stacks (MinStack) | O(1) getMin | parallel stack tracking mins |
| Expression Evaluation | Brackets, calculators | save state on `(`, restore on `)` |

## Queue / Deque Patterns
| Pattern | When to Use | Key Idea |
|---------|------------|---------|
| Monotonic Deque | Sliding window max/min | maintain useful indices |
| Two Heaps | Median, k-th largest | balance max and min heaps |
| BFS Queue | Level-order, shortest path | process level by level |
| Circular Queue | Fixed-size buffer | modulo indexing |

---

*Last updated: 2026-07-23*
*All solutions: Java | LeetCode compatible*