package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: empty list
        if (head == null) {
            return null;
        }
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // Skip the duplicate node
                curr.next = curr.next.next;
            } else {
                // Move to the next node
                curr = curr.next;
            }
        }
        return head;
    }

    static void main() {
        RemoveDuplicatesFromSortedList_83 sol = new RemoveDuplicatesFromSortedList_83();

        // Test Case 1
        int[] arr1 = {1, 1, 2, 3, 3};
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.deleteDuplicates(head1);
        System.out.print("After removing duplicates: ");
        printList(result1);
        System.out.println();
    }
}
