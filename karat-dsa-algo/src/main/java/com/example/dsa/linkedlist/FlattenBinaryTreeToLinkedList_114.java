package com.example.dsa.linkedlist;

import com.example.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList_114 {

    public void flattenRecursive(TreeNode root) {
        if (root == null) return;

        // Flatten left and right subtrees
        flattenRecursive(root.left);
        flattenRecursive(root.right);

        // Store the flattened right subtree
        TreeNode rightSubtree = root.right;

        // Move the flattened left subtree to the right
        root.right = root.left;
        root.left = null;

        // Traverse to the end of the new right subtree
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        // Attach the original right subtree
        current.right = rightSubtree;
    }

    static void main() {
        FlattenBinaryTreeToLinkedList_114 sol = new FlattenBinaryTreeToLinkedList_114();

        // Test Case 1: Standard tree
        // Input: [1,2,5,3,4,null,6]
        // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Integer[] arr1 = {1, 2, 5, 3, 4, null, 6};
        TreeNode root1 = arrayToTree(arr1);
        System.out.println("Test Case 1:");
        System.out.println("Original tree:");
        printTree(root1, "", false);
        System.out.println();
    }

    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) return;
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);
        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }
}
