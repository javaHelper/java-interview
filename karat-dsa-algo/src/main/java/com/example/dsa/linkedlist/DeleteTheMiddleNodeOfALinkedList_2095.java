package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class DeleteTheMiddleNodeOfALinkedList_2095 {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: empty list or single node → nothing to delete
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // tracks the node before slow

        // Fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            prev = slow;              // keep track of the node before slow
            slow = slow.next;         // one step
            fast = fast.next.next;    // two steps
        }

        // Now slow is at the middle node, prev is the node before it
        // Delete the middle node by skipping it
        prev.next = slow.next;

        // Optional: help garbage collection
        slow.next = null;

        return head;
    }

    static void main() {
        DeleteTheMiddleNodeOfALinkedList_2095 sol = new DeleteTheMiddleNodeOfALinkedList_2095();
        // Test Case 1: Odd length (7 nodes) → middle is 7 (index 3)
        int[] arr1 = {1, 3, 4, 7, 1, 2, 6};
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.deleteMiddle(head1);
        System.out.print("After deleting middle: ");
        printList(result1);
        System.out.println("Expected: 1 -> 3 -> 4 -> 1 -> 2 -> 6");
        System.out.println();
    }
}
