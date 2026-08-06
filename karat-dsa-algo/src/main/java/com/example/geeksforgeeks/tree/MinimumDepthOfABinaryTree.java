package com.example.geeksforgeeks.tree;

public class MinimumDepthOfABinaryTree {

    int minDepth(Node root) {
        // Base case: empty tree
        if (root == null) {
            return 0;
        }

        // If leaf node, depth is 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If one child is null, we must explore the other
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both children exist, take the minimum of the two
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    static void main() {
        MinimumDepthOfABinaryTree sol = new MinimumDepthOfABinaryTree();

        // Test Case 1: root = [1, 3, 2, 4]
        // Expected output: 2 (path: 1 -> 2)
        Integer[] arr1 = {1, 3, 2, 4};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Minimum Depth (Test 1): " + sol.minDepth(root1)); // 2
    }
}
