package com.example.geeksforgeeks.tree;

import com.example.dsa.tree.BuildLevelOrderArray;

public class KthLargestInBST {

    // Return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Array to hold count and result (since Java doesn't have pass-by-reference)
        int[] count = new int[]{0};
        int[] result = new int[]{-1};

        // Perform reverse inorder traversal (right -> root -> left)
        reverseInorder(root, k, count, result);
        return result[0];
    }

    // Helper function for reverse inorder traversal
    private void reverseInorder(Node node, int k, int[] count, int[] result) {
        if (node == null || count[0] >= k) {
            return;
        }

        // First traverse right subtree (larger elements)
        reverseInorder(node.right, k, count, result);

        // Increment count for current node
        count[0]++;
        if (count[0] == k) {
            result[0] = node.data;
            return;
        }

        // Then traverse left subtree (smaller elements)
        reverseInorder(node.left, k, count, result);
    }

    static void main() {
        KthLargestInBST solution = new KthLargestInBST();

        // Test Case 1: root = [4, 2, 9], k = 2
        // Tree:     4
        //          / \
        //         2   9
        String[] arr1 = {"4", "2", "9"};
        Node root1 = BuildLevelOrderArray.buildStringTree(arr1);
        System.out.println("Kth largest (k=2): " + solution.kthLargest(root1, 2)); // Expected: 4

        // Test Case 2: root = [9, N, 10], k = 1
        // Tree:     9
        //            \
        //            10
        String[] arr2 = {"9", "N", "10"};
        Node root2 = BuildLevelOrderArray.buildStringTree(arr2);
        System.out.println("Kth largest (k=1): " + solution.kthLargest(root2, 1)); // Expected: 10

        // Test Case 3: root = [4, 2, 9], k = 3
        String[] arr3 = {"4", "2", "9"};
        Node root3 = BuildLevelOrderArray.buildStringTree(arr3);
        System.out.println("Kth largest (k=3): " + solution.kthLargest(root3, 3)); // Expected: 2

        // Test Case 4: Larger BST
        // Tree:       5
        //          /     \
        //         3       8
        //        / \     / \
        //       2   4   7   9
        String[] arr4 = {"5", "3", "8", "2", "4", "7", "9"};
        Node root4 = BuildLevelOrderArray.buildStringTree(arr4);
        System.out.println("Kth largest (k=2): " + solution.kthLargest(root4, 2)); // Expected: 8
        System.out.println("Kth largest (k=4): " + solution.kthLargest(root4, 4)); // Expected: 5
    }
}
