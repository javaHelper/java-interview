package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class MergeTwoSortedLists_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node
        ListNode dummy = new ListNode(-1);

        // Current pointer
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }

    static void main() {
        MergeTwoSortedLists_21 sol = new MergeTwoSortedLists_21();

        // Test Case 1: Standard case
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1, 3, 4};
        ListNode list1 = arrayToList(arr1);
        ListNode list2 = arrayToList(arr2);
        System.out.print("List1: ");
        printList(list1);
        System.out.print("List2: ");
        printList(list2);
        ListNode result = sol.mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(result);
        System.out.println();
    }
}
