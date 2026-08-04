package com.example.dsa.bitmanupulation;

public class NumberOf1Bits_191 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    static void main() {
        NumberOf1Bits_191 n = new NumberOf1Bits_191();
        System.out.println(n.hammingWeight(11));
        System.out.println(n.hammingWeight(128));
        System.out.println(n.hammingWeight(2147483645));
    }
}
