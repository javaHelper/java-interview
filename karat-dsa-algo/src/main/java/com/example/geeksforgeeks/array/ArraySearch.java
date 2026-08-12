package com.example.geeksforgeeks.array;

public class ArraySearch {

    public int search(int arr[], int x) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == x){
                return i;
            }
        }
        return -1;
    }

    static void main() {
        ArraySearch x = new ArraySearch();
        System.out.println(x.search(new int[]{1, 2, 3, 4}, 3));
        System.out.println(x.search(new int[]{10, 8, 30, 4, 5}, 5));
    }
}
