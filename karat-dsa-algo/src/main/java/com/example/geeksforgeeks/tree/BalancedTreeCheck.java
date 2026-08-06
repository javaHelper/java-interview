package com.example.geeksforgeeks.tree;

public class BalancedTreeCheck {
    private static int checkHeight(Node root) {
        if (root == null) {
            return 0; // Height of empty tree is 0
        }

        // Check left subtree
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return - 1; // Left subtree is not balanced

        // Check right subtree
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return - 1; // Right subtree is not balanced

        // If current node is unbalanced, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return - 1;
        }

        // Return height of this subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Main function to check if tree is balanced
    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    static void main() {

    }
}
