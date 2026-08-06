package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class SwapNodesInPairs_24 {

    public ListNode swapPairs(ListNode head) {
        // Edge case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            // Swap the pair
            temp.next = node2;           // Connect previous part to node2
            node1.next = node2.next;     // Connect node1 to the rest of the list
            node2.next = node1;          // Connect node2 to node1

            // Move temp forward for the next pair
            temp = node1;
        }

        return dummy.next;
    }

    static void main() {
        SwapNodesInPairs_24 sol = new SwapNodesInPairs_24();

        // Test Case 1: Even length
        int[] arr1 = {1, 2, 3, 4};
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.swapPairs(head1);
        System.out.print("After swapping pairs: ");
        printList(result1);
        System.out.println("Expected: 2 -> 1 -> 4 -> 3");
        System.out.println();
    }
}
