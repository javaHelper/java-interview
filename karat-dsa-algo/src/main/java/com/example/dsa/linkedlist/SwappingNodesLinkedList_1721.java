package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class SwappingNodesLinkedList_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        // Find the k-th node from the beginning
        ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode left = fast;  // k-th from beginning

        // Find the k-th node from the end
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode right = slow; // k-th from end

        // Swap values
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }

    static void main() {
        SwappingNodesLinkedList_1721 x = new SwappingNodesLinkedList_1721();

        // Example 1: [1,2,3,4,5], k = 2 → Expected: [1,4,3,2,5]
        int[] arr1 = {1, 2, 3, 4, 5};
        ListNode list1 = arrayToList(arr1);
        System.out.print("Original: ");
        printList(list1);
        ListNode swapped1 = x.swapNodes(list1, 2);
        System.out.print("After swap (k=2): ");
        printList(swapped1);

        // Example 2: [7,9,6,6,7,8,3,0,9,5], k = 5
        int[] arr2 = {7, 9, 6, 6, 7, 8, 3, 0, 9, 5};
        ListNode list2 = arrayToList(arr2);
        System.out.print("Original: ");
        printList(list2);
        ListNode swapped2 = x.swapNodes(list2, 5);
        System.out.print("After swap (k=5): ");
        printList(swapped2);

        // Edge case: k = 1 (swap first and last)
        int[] arr3 = {10, 20, 30, 40, 50};
        ListNode list3 = arrayToList(arr3);
        System.out.print("Original: ");
        printList(list3);
        ListNode swapped3 = x.swapNodes(list3, 1);
        System.out.print("After swap (k=1): ");
        printList(swapped3);

        // Edge case: k = n (swap last and first - same as k=1)
        int[] arr4 = {100, 200, 300};
        ListNode list4 = arrayToList(arr4);
        System.out.print("Original: ");
        printList(list4);
        ListNode swapped4 = x.swapNodes(list4, 3);
        System.out.print("After swap (k=3): ");
        printList(swapped4);
    }
}
