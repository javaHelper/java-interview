package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        // Edge cases: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length and the tail node
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: Calculate effective rotation
        k = k % len;
        if (k == 0) {
            return head;
        }

        // Step 3: Close the list into a ring
        tail.next = head;

        // Step 4: Find the new tail (at position len - k from start)
        ListNode newTail = head;
        for (int i = 1; i < len - k; i++) {
            newTail = newTail.next;
        }

        // Step 5: Break the ring at the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }


    static void main() {
        RotateList_61 x = new RotateList_61();

        // Example 1: [1,2,3,4,5], k = 2
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode list1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(list1);
        ListNode rotated1 = x.rotateRight(list1, 2);
        System.out.print("After rotating by 2: ");
        printList(rotated1);

        // Example 2: [0,1,2], k = 4
        int[] arr2 = {0, 1, 2};
        ListNode list2 = arrayToList(arr2);
        System.out.print("Original: ");
        printList(list2);
        ListNode rotated2 = x.rotateRight(list2, 4);
        System.out.print("After rotating by 4: ");
        printList(rotated2);

        // Example 3: empty list
        ListNode list3 = arrayToList(new int[]{});
        System.out.print("Original: ");
        printList(list3);
        ListNode rotated3 = x.rotateRight(list3, 0);
        System.out.print("After rotating by 0: ");
        printList(rotated3);

        // Example 4: single node
        ListNode list4 = arrayToList(new int[]{1});
        System.out.print("Original: ");
        printList(list4);
        ListNode rotated4 = x.rotateRight(list4, 10);
        System.out.print("After rotating by 10: ");
        printList(rotated4);
    }
}
