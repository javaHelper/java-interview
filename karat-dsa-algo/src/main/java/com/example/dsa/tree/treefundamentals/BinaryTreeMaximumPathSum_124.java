package com.example.dsa.tree.treefundamentals;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

public class BinaryTreeMaximumPathSum_124 {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the maximum contribution from left and right subtrees.
        // If a contribution is negative, we treat it as 0 (ignore that path).
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // The max path sum that goes through this node (splitting at this node).
        int currentMaxPath = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentMaxPath);

        // Return the maximum contribution this node can provide to its parent
        // (only one branch can be chosen to go upward).
        return node.val + Math.max(leftGain, rightGain);
    }

    static void main() {
        BinaryTreeMaximumPathSum_124 sol = new BinaryTreeMaximumPathSum_124();

        // Example 1: [1, 2, 3]
        // The path 2 -> 1 -> 3 gives sum = 6.
        Integer[] arr1 = {1, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Maximum path sum for [1,2,3]: " + sol.maxPathSum(root1)); // Output: 6

        // Example 2: [-10, 9, 20, null, null, 15, 7]
        // The path 15 -> 20 -> 7 gives sum = 42.
        Integer[] arr2 = {-10, 9, 20, null, null, 15, 7};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Maximum path sum for [-10,9,20,null,null,15,7]: " + sol.maxPathSum(root2)); // Output: 42

        // Example 3: [-3]
        Integer[] arr3 = {-3};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Maximum path sum for [-3]: " + sol.maxPathSum(root3)); // Output: -3

        // Example 4: [2, -1, -2]
        // The max path is just the root 2 (since both children are negative).
        Integer[] arr4 = {2, -1, -2};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(arr4);
        System.out.println("Maximum path sum for [2,-1,-2]: " + sol.maxPathSum(root4)); // Output: 2
    }
}
