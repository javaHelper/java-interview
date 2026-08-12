package com.example.geeksforgeeks.tree;

public class MaxAndMinElementInBinaryTree {
    /**
     * Finds the maximum element in the binary tree.
     *
     * @param root the root of the binary tree
     * @return the maximum value in the tree
     */
    public static int findMax(Node root) {
        // Base case: empty tree → return smallest possible value
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        // Maximum of current node, left subtree, and right subtree
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    /**
     * Finds the minimum element in the binary tree.
     *
     * @param root the root of the binary tree
     * @return the minimum value in the tree
     */
    public static int findMin(Node root) {
        // Base case: empty tree → return largest possible value
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        // Minimum of current node, left subtree, and right subtree
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    static void main() {
        // Example 1: [11, 5, 3, 8] → Max = 11, Min = 3
        Integer[] arr1 = {11, 5, 3, 8};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Max: " + findMax(root1) + ", Min: " + findMin(root1)); // Max: 11, Min: 3

        // Example 2: [6, 5, 8, null, null, 2] → Max = 8, Min = 2
        Integer[] arr2 = {6, 5, 8, null, null, 2};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Max: " + findMax(root2) + ", Min: " + findMin(root2)); // Max: 8, Min: 2

        // Example 3: Single node [42] → Max = 42, Min = 42
        Integer[] arr3 = {42};
        Node root3 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Max: " + findMax(root3) + ", Min: " + findMin(root3)); // Max: 42, Min: 42

        // Example 4: Empty tree → Max = Integer.MIN_VALUE, Min = Integer.MAX_VALUE
        Node root4 = BuildTreeLevelOrderArray.buildTreeLevelOrder(new Integer[]{});
        System.out.println("Max: " + findMax(root4) + ", Min: " + findMin(root4)); // Max: -2147483648, Min: 2147483647
    }
}
