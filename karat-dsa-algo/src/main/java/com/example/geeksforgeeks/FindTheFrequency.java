package com.example.geeksforgeeks;

public class FindTheFrequency {
    int findFrequency(int arr[], int x) {
        int count = 0;
        for (int num: arr){
            if(num == x){
                count++;
            }
        }
        return count;
    }

    static void main() {
        FindTheFrequency sol = new FindTheFrequency();
        System.out.println(sol.findFrequency(new int[]{1, 1, 1, 1, 1}, 1));
    }
}
