package com.example.dsa.linkedlist;

import static com.example.dsa.linkedlist.ListNodeHelper.createIntersectingLists;

public class IntersectionOfTwoLinkedLists_160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }

    static void main() {
        IntersectionOfTwoLinkedLists_160 sol = new IntersectionOfTwoLinkedLists_160();

        // Test Case 1: Intersecting lists
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], intersection at 8 (skipA=2, skipB=3)
        int[] arrA1 = {4, 1, 8, 4, 5};
        int[] arrB1 = {5, 6, 1, 8, 4, 5};
        ListNode[] result1 = createIntersectingLists(arrA1, arrB1, 2, 3);
        ListNode headA1 = result1[0];
        ListNode headB1 = result1[1];
        ListNode expected1 = result1[2];

        System.out.println("Test Case 1: Intersecting Lists");
        printList(headA1, "List A");
        printList(headB1, "List B");
        ListNode intersection1 = sol.getIntersectionNode(headA1, headB1);
        System.out.println("Intersection node value: " + (intersection1 != null ? intersection1.val : "null"));
        System.out.println("Expected: " + (expected1 != null ? expected1.val : "null"));
        System.out.println("Passed: " + (intersection1 == expected1));
        System.out.println();
    }


    public static void printList(ListNode head, String name) {
        System.out.print(name + ": ");
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }
}
