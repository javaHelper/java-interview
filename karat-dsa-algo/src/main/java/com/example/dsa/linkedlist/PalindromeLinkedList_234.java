package com.example.dsa.linkedlist;

import java.util.ArrayList;
import java.util.List;

import static com.example.dsa.linkedlist.ListNodeHelper.arrayToList;
import static com.example.dsa.linkedlist.ListNodeHelper.printList;

public class PalindromeLinkedList_234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> values = new ArrayList<>();

        // Copy values to array
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        // Check if array is palindrome
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            if (!values.get(left).equals(values.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static void main() {
        PalindromeLinkedList_234 sol = new PalindromeLinkedList_234();

        // Test Case 1: Palindrome (even length)
        int[] arr1 = {1, 2, 2, 1};
        ListNode head1 = arrayToList(arr1);
        System.out.print("List: ");
        printList(head1);
        boolean result1 = sol.isPalindrome(head1);
        System.out.println("Is palindrome? " + result1);
        System.out.println("Expected: true");
        System.out.println();

    }
}
