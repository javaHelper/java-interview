package com.example.linkedlist;

public class ListNodeHelper {
    // Helper: convert int array to a linked list
    public static ListNode arrayToList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);

        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Helper: convert linked list to int array (for easy printing)
    public static int[] listToArray(ListNode head) {
        // First, count the nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int[] result = new int[count];
        int i = 0;
        while (head != null) {
            result[i++] = head.val;
            head = head.next;
        }
        return result;
    }
}
