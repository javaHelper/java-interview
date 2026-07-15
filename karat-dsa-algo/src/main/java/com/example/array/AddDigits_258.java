package com.example.array;

public class AddDigits_258 {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return 1 + (num - 1) % 9;
    }

    public static void main(String[] args) {
        AddDigits_258 x = new AddDigits_258();
        System.out.println(x.addDigits(38)); // Output: 2
        System.out.println(x.addDigits(8989)); // Output: 1
    }
}
