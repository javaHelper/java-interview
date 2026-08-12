package com.example.geeksforgeeks.queue;

public class QueueUsingArray {
    static class myQueue {

        int[] arr;

        int front;
        int rear;
        int size;
        int capacity;
        // Constructor

        public myQueue(int n) {
            capacity = n;
            arr = new int[n];
            front = 0;
            rear = -1;
            size = 0;
        }
        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        public void enqueue(int x) {
            if (isFull()) {
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = x;
            size++;
        }

        public void dequeue() {
            if (isEmpty()) {
                return;
            }
            front = (front + 1) % capacity;
            size--;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return arr[front];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            return arr[rear];
        }

    }
    static void main() {
        myQueue q = new myQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front : " + q.getFront());
        System.out.println("Rear  : " + q.getRear());

        q.dequeue();

        System.out.println("After Dequeue");
        System.out.println("Front : " + q.getFront());
        System.out.println("Rear  : " + q.getRear());

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        System.out.println("Front : " + q.getFront());
        System.out.println("Rear  : " + q.getRear());
    }
}
