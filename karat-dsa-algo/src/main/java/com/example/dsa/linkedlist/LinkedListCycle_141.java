package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToListWithCycle;
import static com.example.dsa.linkedlist.ListNodeHelper.printList1;

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        // If list is empty or has only one node, no cycle
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move one step
            fast = fast.next.next;     // move two steps
            if (slow == fast) {        // they met → cycle exists
                return true;
            }
        }
        return false; // fast reached end → no cycle
    }

    static void main() {
        LinkedListCycle_141 sol = new LinkedListCycle_141();
        // Test Case 1: Cycle exists (pos = 1)
        int[] arr1 = {3, 2, 0, -4};
        int pos1 = 1;
        ListNode head1 = arrayToListWithCycle(arr1, pos1);
        System.out.print("List1 (cycle at pos " + pos1 + "): ");
        printList1(head1, 10);
        boolean result1 = sol.hasCycle(head1);
        System.out.println("Has cycle? " + result1);
        System.out.println();
    }
}
