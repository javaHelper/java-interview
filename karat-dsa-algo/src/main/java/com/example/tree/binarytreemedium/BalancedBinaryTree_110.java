package com.example.tree.binarytreemedium;

import com.example.tree.treefundamentals.BuildLevelOrderArray;

public class BalancedBinaryTree_110 {
    // ==================== BOTTOM-UP RECURSIVE SOLUTION (OPTIMAL) ====================
    /**
     * Checks if a binary tree is height-balanced using bottom-up recursion.
     * Returns -1 if unbalanced, otherwise returns the height of the tree.
     *
     * Time: O(n) — each node visited once.
     * Space: O(h) — recursion stack (h = tree height, O(log n) for balanced trees, O(n) worst-case).
     */
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        if (node == null) {
            return 0; // Base case: empty tree has height 0
        }

        // Recursively get height of left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced, propagate -1 up
        }

        // Recursively get height of right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced, propagate -1 up
        }

        // Check if current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is unbalanced
        }

        // Return height of current node: 1 + max height of its subtrees
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // ==================== TOP-DOWN RECURSIVE SOLUTION (BRUTE FORCE) ====================
    /**
     * Checks if a binary tree is height-balanced using top-down recursion.
     * For each node, checks if its subtrees are balanced and computes their heights.
     *
     * Time: O(n^2) — each node's height is recomputed multiple times.
     * Space: O(h) — recursion stack.
     */
    public boolean isBalancedTopDown(TreeNode root) {
        if (root == null) {
            return true;
        }

        // Check if current node is balanced
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Recursively check left and right subtrees
        return isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        BalancedBinaryTree_110 solution = new BalancedBinaryTree_110();

        // Test case 1: [3,9,20,null,null,15,7] → true (balanced)
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Test 1 (Bottom-Up): " + solution.isBalanced(root1));
        System.out.println("Test 1 (Top-Down):  " + solution.isBalancedTopDown(root1));

        // Test case 2: [1,2,2,3,3,null,null,4,4] → false (unbalanced)
        Integer[] arr2 = {1, 2, 2, 3, 3, null, null, 4, 4};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 2 (Bottom-Up): " + solution.isBalanced(root2));
        System.out.println("Test 2 (Top-Down):  " + solution.isBalancedTopDown(root2));

        // Test case 3: [] → true (empty tree is balanced)
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        System.out.println("Test 3 (Bottom-Up): " + solution.isBalanced(root3));
        System.out.println("Test 3 (Top-Down):  " + solution.isBalancedTopDown(root3));

        // Test case 4: [1] → true (single node is balanced)
        Integer[] arr4 = {1};
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 4 (Bottom-Up): " + solution.isBalanced(root4));
        System.out.println("Test 4 (Top-Down):  " + solution.isBalancedTopDown(root4));

        // Test case 5: [1,2,2,3,null,null,3,4,null,null,4] → false (unbalanced)
        Integer[] arr5 = {1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root5 = BuildLevelOrderArray.buildTree(arr5);
        System.out.println("Test 5 (Bottom-Up): " + solution.isBalanced(root5));
        System.out.println("Test 5 (Top-Down):  " + solution.isBalancedTopDown(root5));
    }
}
