package com.example.geeksforgeeks.recursion;

public class MeanOfArrayUsingRecursion {

     double findMeanRec(int[] arr, int n){
        // Base case
        if (n == 1)
            return arr[0];

        // Recursive case
        return (findMeanRec(arr, n - 1) * (n - 1) + arr[n - 1]) / n;
    }

    static void main() {
        MeanOfArrayUsingRecursion x = new MeanOfArrayUsingRecursion();

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(x.findMeanRec(arr, arr.length));
    }
}
