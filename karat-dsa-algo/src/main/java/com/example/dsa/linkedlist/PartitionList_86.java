package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        // Dummy nodes for the two partitions
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        // Pointers to build the two lists
        ListNode lessTail = lessDummy;
        ListNode greaterTail = greaterDummy;

        // Traverse the original list
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                // Append to "less" list
                lessTail.next = curr;
                lessTail = lessTail.next;
            } else {
                // Append to "greater/equal" list
                greaterTail.next = curr;
                greaterTail = greaterTail.next;
            }
            curr = curr.next;
        }

        // Connect the two partitions
        lessTail.next = greaterDummy.next;
        // Important: avoid cycle by setting the end of greater list to null
        greaterTail.next = null;

        // Return the head of the "less" list (skip dummy)
        return lessDummy.next;
    }

    static void main() {
        PartitionList_86 sol = new PartitionList_86();

        // Test Case 1: Standard case
        int[] arr1 = {1, 4, 3, 2, 5, 2};
        int x1 = 3;
        ListNode head1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(head1);
        ListNode result1 = sol.partition(head1, x1);
        System.out.print("After partitioning (x=" + x1 + "): ");
        printList(result1);
        System.out.println("Expected: 1 -> 2 -> 2 -> 4 -> 3 -> 5");
        System.out.println();
    }
}
