package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.printList;

/**
 * <h3>Step 1: Understand the Core Problem of Linked Lists</h3>
 * In a singly linked list, a node only knows its next node.
 * To <b>delete</b> a node (let's call it curr), we must change the next pointer of the previous node so that it skips curr:
 *
 * prev.next = curr.next
 *
 * <b>The biggest challenge: </b> The very first node (head) has no previous node. If the head needs to be deleted, we have no prev to update.
 *
 *
 * <h3>Step 2: The "Dummy" Trick (Sentinel Node)</h3>
 * To fix the "no previous node" problem, we create a fake node right before the head.
 *
 * java
 * ListNode dummy = new ListNode(0);
 * dummy.next = head;
 * Visual:
 * If our list is 1 -> 2 -> 6 -> 3, we now have:
 * [dummy: 0] -> 1 -> 2 -> 6 -> 3
 * Now, every real node (including the original head 1) has a previous node. This removes the need for special if statements just for the head.
 *
 */



public class RemoveLinkedListElements_203 {

    public ListNode removeElements(ListNode head, int val) {
        // dummy node simplifies the removal of element
        ListNode newNode = new ListNode(0);
        newNode.next = head;

        // Points to the node BEFORE the one we are checking
        ListNode prev = newNode;
        // Points to the node we are currently checking
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                // Skip the current node
                prev.next = curr.next;
            } else {
                // Move prev forward only when no deletion occurs
                prev = curr;
            }
            curr = curr.next;
        }
        return newNode.next;
    }

    static void main() {
        RemoveLinkedListElements_203 sol = new RemoveLinkedListElements_203();

        // Test Case 1
        int val1 = 6;
        ListNode head1 = ListNodeHelper.arrayToList(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.print("Original: ");

        printList(head1);

        ListNode result1 = sol.removeElements(head1, val1);
        System.out.print("After removing " + val1 + ": ");

        printList(result1);
        System.out.println();
    }
}
