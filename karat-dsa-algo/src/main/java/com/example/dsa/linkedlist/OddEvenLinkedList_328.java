package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class OddEvenLinkedList_328 {
    public ListNode oddEvenList(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;                // points to the last node in odd list
        ListNode even = head.next;          // points to the last node in even list
        ListNode evenHead = even;           // save the head of even list

        // Traverse and rearrange
        while (even != null && even.next != null) {
            odd.next = even.next;           // link odd to next odd node
            odd = odd.next;                 // move odd pointer forward

            even.next = odd.next;           // link even to next even node
            even = even.next;               // move even pointer forward
        }

        // Connect odd list with even list
        odd.next = evenHead;

        return head;
    }

    static void main() {
        OddEvenLinkedList_328 sol = new OddEvenLinkedList_328();

        // Test Case 1: Standard case (odd length)
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.oddEvenList(head1);
        System.out.print("After odd-even grouping: ");
        printList(result1);
        System.out.println("Expected: 1 -> 3 -> 5 -> 2 -> 4");
        System.out.println();
    }
}
