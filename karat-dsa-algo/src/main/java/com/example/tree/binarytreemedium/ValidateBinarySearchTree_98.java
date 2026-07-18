package com.example.tree.binarytreemedium;

import com.example.tree.TreeNode;

public class ValidateBinarySearchTree_98 {
    /**
     * Validates if a binary tree is a valid BST.
     * Uses a recursive helper with upper and lower bounds.
     * <p>
     * Time Complexity: O(n) - visits each node once [reference:0]
     * Space Complexity: O(h) - recursion stack, h = tree height [reference:1]
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private boolean isValidBSTHelper(TreeNode node, Integer lower, Integer upper) {
        // Empty tree is a valid BST
        if (node == null) {
            return true;
        }

        int val = node.val;

        // Check if current node's value violates the bounds
        if ((lower != null && val <= lower) || (upper != null && val >= upper)) {
            return false;
        }

        // Recursively validate left and right subtrees with updated bounds
        // Left subtree: values must be < node.val (upper bound becomes node.val)
        // Right subtree: values must be > node.val (lower bound becomes node.val)
        return isValidBSTHelper(node.left, lower, val)
                && isValidBSTHelper(node.right, val, upper);
    }
}
