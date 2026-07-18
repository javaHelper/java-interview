package com.example.tree.binarytreemedium;

import com.example.tree.treefundamentals.BuildLevelOrderArray;

public class PathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        // Inner node: subtract current value and check both subtrees
        int remaining = targetSum - root.val;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    static void main() {
        PathSum_112 x = new PathSum_112();

        // Your original tree in level‑order (LeetCode style)
        Integer[] treeValues = {
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, 1
        };

        // Build the tree dynamically
        TreeNode root = BuildLevelOrderArray.buildTree(treeValues);

        // Test path sum
        int target = 22;
        boolean result = x.hasPathSum(root, target);
        System.out.println("Has path sum " + target + "? " + result);  // true
    }
}
