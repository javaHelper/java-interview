package com.example.geeksforgeeks.tree;

import com.example.dsa.tree.BuildLevelOrderArray;

public class CheckForBST {
    // Function to check whether a Binary Tree is a BST
    public boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // Helper function to check BST with valid range
    private boolean isBSTUtil(Node node, long min, long max) {
        // An empty tree is a BST
        if (node == null) {
            return true;
        }

        // If current node's data is outside the valid range, not a BST
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively check left subtree (values must be < node.data)
        // and right subtree (values must be > node.data)
        return isBSTUtil(node.left, min, node.data) &&
                isBSTUtil(node.right, node.data, max);
    }

    static void main() {
        CheckForBST x = new CheckForBST();

        // Test Case 1: Valid BST
        // Tree:     2
        //          / \
        //         1   3
        //              \
        //               5
        String[] arr1 = {"2", "1", "3", "N", "N", "N", "5"};
        Node root1 = BuildLevelOrderArray.buildStringTree(arr1);
        System.out.println("Is BST? => " + x.isBST(root1));  // true

        // Test Case 2: Invalid BST (right subtree has smaller value)
        // Tree:     2
        //          / \
        //         1   7
        //            /
        //           6
        String[] arr2 = {"2", "1", "7", "N", "N", "6", "N"};
        Node root2 = BuildLevelOrderArray.buildStringTree(arr2);
        System.out.println("Is BST? => " + x.isBST(root2));  // false

        // Test Case 3: Invalid BST (right subtree has value less than root)
        // Tree:     10
        //          /  \
        //         5   20
        //            /  \
        //           9   25
        String[] arr3 = {"10", "5", "20", "N", "N", "9", "25"};
        Node root3 = BuildLevelOrderArray.buildStringTree(arr3);
        System.out.println("Is BST? => " + x.isBST(root3));  // false
    }
}
