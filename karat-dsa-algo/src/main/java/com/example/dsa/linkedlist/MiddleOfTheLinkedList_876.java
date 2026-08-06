package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {

        // If list is empty or has only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Fast moves twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;          // one step
            fast = fast.next.next;     // two steps
        }

        // Slow is now at the middle node
        return slow;
    }

    static void main() {
        MiddleOfTheLinkedList_876 sol = new MiddleOfTheLinkedList_876();

        // Test Case 1: Odd length → middle is 3
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.middleNode(head1);
        System.out.print("Middle node (and rest): ");
        printList(result1);
        System.out.println();
    }
}
