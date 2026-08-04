package com.example.dsa.linkedlist;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);      // Dummy node to anchor the result list
        ListNode current = dummy;              // Pointer to build the result
        int carry = 0;

        // Traverse until both lists are exhausted and no carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            current.next = new ListNode(sum % 10);  // Store the current digit
            carry = sum / 10;                       // Update carry for next step
            current = current.next;                 // Move pointer forward
        }

        return dummy.next;  // Skip the dummy node and return the actual head
    }
}
