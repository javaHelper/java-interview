package com.example.geeksforgeeks.string;

/**
 * Time	O(n) – We swap n/2 pairs, each swap is O(1). Total O(n).
 * Space O(n) – The char[] array uses n characters. (The input string is immutable,
 *          so we need a mutable copy.) If you consider only extra space beyond the input,
 *          it is O(n).
 */
public class ReverseStringUsingTwoPointer {

    public String reverse(String s) {
        // Convert to mutable char array
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap characters
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        ReverseStringUsingTwoPointer r = new ReverseStringUsingTwoPointer();
        System.out.println(r.reverse("GeeksforGeeks"));
    }
}
