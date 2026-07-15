package com.example.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeExample {
    static void main() {
        //method1();
        //method2();

        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.addFirst("0");
        deque.addLast("100");

        System.out.println(deque);
        System.out.println(deque.pop());

        System.out.println(deque.poll());
        System.out.println(deque);

        System.out.println(deque.removeFirst());
        System.out.println(deque);

        System.out.println(deque.removeLast());
        System.out.println(deque);
    }

    private static void method2() {
        Deque<String> deque = new ArrayDeque<>();
        deque.add("1");
        deque.add("2");
        deque.addFirst("0");
        deque.addFirst("00");
        deque.addLast("100");

        System.out.println(deque);
    }

    private static void method1() {
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("1");
        deque.addLast("2");

        String f = deque.removeFirst();
        String l = deque.removeLast();

        // Displaying the Deque
        System.out.println("First: " + f + ", Last: " + l);
    }
}
