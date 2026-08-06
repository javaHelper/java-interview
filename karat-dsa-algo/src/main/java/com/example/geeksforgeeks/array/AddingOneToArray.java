package com.example.geeksforgeeks.array;

import java.util.LinkedList;
import java.util.Vector;

public class AddingOneToArray {

    public Vector<Integer> addOne(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + carry;
            if (sum == 10) {
                list.addFirst(0);
                carry = 1;
            } else {
                list.addFirst(sum);
                carry = 0;
            }
        }
        if (carry == 1) {
            list.addFirst(1);
        }

        return new Vector<>(list);
    }

    static void main() {

    }
}
