package com.example.tree.binarytreemedium;

import com.example.tree.treefundamentals.BuildLevelOrderArray;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    // ==================== RECURSIVE SOLUTION (DFS) ====================
    /**
     * Inverts a binary tree using recursion (Depth-First Search).
     * Time: O(n)  |  Space: O(h) — recursion stack (h = tree height)
     * 
     * At each node, swap its left and right children, then recursively
     * invert the left and right subtrees.[reference:0][reference:1]
     */
    public TreeNode invertTreeRecursive(TreeNode root) {
        if (root == null) {
            return null;
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the subtrees
        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);

        return root;
    }

    // ==================== ITERATIVE SOLUTION (BFS with Queue) ====================
    /**
     * Inverts a binary tree iteratively using a queue (Breadth-First Search).
     * Time: O(n)  |  Space: O(n) — queue holds at most one level of nodes.
     * 
     * Process nodes level by level, swapping children of each node.[reference:2]
     */
    public TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Swap left and right children
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            // Add children to queue for processing
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;
    }

    // ==================== HELPER: Level-Order Traversal for Printing ====================
    /**
     * Converts a tree to a level-order list for easy visualization.
     * Used only for testing output.
     */
    public static String treeToString(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        // Remove trailing nulls for cleaner output
        String result = sb.toString();
        while (result.endsWith(", null")) {
            result = result.substring(0, result.length() - 6);
        }
        result += "]";
        return result;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        InvertBinaryTree_226 solution = new InvertBinaryTree_226();

        // Test case 1: [4,2,7,1,3,6,9] → Expected: [4,7,2,9,6,3,1]
        Integer[] arr1 = {4, 2, 7, 1, 3, 6, 9};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Test 1 - Original:  " + treeToString(root1));
        TreeNode inverted1 = solution.invertTreeRecursive(root1);
        System.out.println("Test 1 - Recursive: " + treeToString(inverted1));
        System.out.println("Test 1 - Expected:   [4, 7, 2, 9, 6, 3, 1]");
        System.out.println();

        // Test case 2: [2,1,3] → Expected: [2,3,1]
        Integer[] arr2 = {2, 1, 3};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 2 - Original:  " + treeToString(root2));
        TreeNode inverted2 = solution.invertTreeIterative(root2);
        System.out.println("Test 2 - Iterative: " + treeToString(inverted2));
        System.out.println("Test 2 - Expected:   [2, 3, 1]");
        System.out.println();

        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        System.out.println("Test 3 - Original:  " + treeToString(root3));
        TreeNode inverted3 = solution.invertTreeRecursive(root3);
        System.out.println("Test 3 - Recursive: " + treeToString(inverted3));
        System.out.println("Test 3 - Expected:   []");
        System.out.println();

        // Test case 4: [1] → Expected: [1]
        Integer[] arr4 = {1};
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 4 - Original:  " + treeToString(root4));
        TreeNode inverted4 = solution.invertTreeIterative(root4);
        System.out.println("Test 4 - Iterative: " + treeToString(inverted4));
        System.out.println("Test 4 - Expected:   [1]");
        System.out.println();

        // Test case 5: [1,2] → Expected: [1,null,2] (represented as [1, null, 2])
        Integer[] arr5 = {1, 2};
        TreeNode root5 = BuildLevelOrderArray.buildTree(arr5);
        System.out.println("Test 5 - Original:  " + treeToString(root5));
        TreeNode inverted5 = solution.invertTreeRecursive(root5);
        System.out.println("Test 5 - Recursive: " + treeToString(inverted5));
        System.out.println("Test 5 - Expected:   [1, null, 2]");
    }
}