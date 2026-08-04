package com.example.dsa.linkedlist;

import java.util.Arrays;

import static com.example.dsa.linkedlist.ListNodeHelper.*;

public class ReverseLinkedList_206 {

    // Solution 1: Iterative (3‑Pointer) — O(n) Time, O(1) Space
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null){
            // save the next node
            ListNode next = curr.next;

            // reverse the link
            curr.next = prev;

            // move prev forward
            prev = curr;

            // move curr forward
            curr = next;
        }
        // new head of the reversed list
        return prev;
    }

    static void main() {
        // 1. Pass your array here – change these values as you like
        int[] inputArray = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(inputArray));

        // 2. Convert array → linked list
        ListNode head = arrayToList(inputArray);

        // 3. Reverse the linked list
        ReverseLinkedList_206 solution = new ReverseLinkedList_206();
        ListNode reversedHead = solution.reverseList(head);

        // 4. Convert reversed linked list → array for display
        int[] reversedArray = listToArray(reversedHead);

        System.out.println("Reversed array:  " + Arrays.toString(reversedArray));
    }
}
