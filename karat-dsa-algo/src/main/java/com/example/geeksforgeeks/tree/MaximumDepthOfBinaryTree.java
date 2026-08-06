package com.example.geeksforgeeks.tree;

public class MaximumDepthOfBinaryTree {

    int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    static void main() {
        MaximumDepthOfBinaryTree sol = new MaximumDepthOfBinaryTree();

        // Test Case 1: root = [12, 8, 18, 5, 11]
        // Tree:
        //        12
        //       /  \
        //      8    18
        //     / \
        //    5   11
        // Height (edges) = 2
        Integer[] arr1 = {12, 8, 18, 5, 11};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Height (recursive edges): " + sol.maxDepth(root1));        // 2
    }
}

