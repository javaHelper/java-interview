package com.example.dsa.tree.treefundamentals;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static void main() {
        MaximumDepthOfBinaryTree_104 sol = new MaximumDepthOfBinaryTree_104();

        // Example from LeetCode: [3,9,20,null,null,15,7]
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(array);

        int depth = sol.maxDepth(root);
        System.out.println("Maximum depth of the tree: " + depth);

        Integer[] array2 = {1, null, 2};
        root = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        depth = sol.maxDepth(root);
        System.out.println("Maximum depth of the tree: " + depth);
    }
}
