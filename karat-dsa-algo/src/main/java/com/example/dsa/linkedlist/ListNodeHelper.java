package com.example.dsa.linkedlist;

public class ListNodeHelper {

    // Helper: Convert an array to a linked list and create a cycle if pos >= 0
    // pos indicates the index (0-based) where the tail connects back to
    public static ListNode arrayToListWithCycle(int[] arr, int pos) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        ListNode cycleNode = null;

        // Build the list
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        // If pos is valid, create a cycle by connecting tail to node at index pos
        if (pos >= 0 && pos < arr.length) {
            cycleNode = head;
            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }
            current.next = cycleNode; // tail points back to cycleNode
        }

        return head;
    }


    // Helper: Print a linked list (only works for lists without cycles!)
    public static void printList1(ListNode head, int limit) {
        ListNode current = head;
        int count = 0;
        while (current != null && count < limit) {
            System.out.print(current.val);
            if (current.next != null && count < limit - 1) System.out.print(" -> ");
            current = current.next;
            count++;
        }
        if (count == limit) System.out.print(" ... (cycle detected, truncated)");
        System.out.println();
    }

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

    // Helper: print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }




    public static ListNode[] createIntersectingLists(int[] arrA, int[] arrB, int skipA, int skipB) {
        // Build list A
        ListNode headA = null;
        ListNode tailA = null;
        ListNode intersectionNode = null;

        for (int i = 0; i < arrA.length; i++) {
            ListNode newNode = new ListNode(arrA[i]);
            if (headA == null) {
                headA = newNode;
                tailA = newNode;
            } else {
                tailA.next = newNode;
                tailA = newNode;
            }
            // If this is the intersection node (based on skipA)
            if (i == skipA) {
                intersectionNode = newNode;
            }
        }

        // Build list B up to skipB nodes, then connect to intersection
        ListNode headB = null;
        ListNode tailB = null;

        for (int i = 0; i < arrB.length; i++) {
            ListNode newNode = new ListNode(arrB[i]);
            if (headB == null) {
                headB = newNode;
                tailB = newNode;
            } else {
                tailB.next = newNode;
                tailB = newNode;
            }
            // When we reach skipB, connect to intersection node
            if (i == skipB - 1) {
                tailB.next = intersectionNode;
                break;
            }
        }

        return new ListNode[]{headA, headB, intersectionNode};
    }
}
