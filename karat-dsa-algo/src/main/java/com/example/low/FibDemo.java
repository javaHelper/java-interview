package com.example.low;

public class FibDemo {
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib (n-2);
    }

    static void main() {
        FibDemo demo = new FibDemo();
        System.out.println(demo.fib(4));
        System.out.println(demo.fib(5));
    }
}
