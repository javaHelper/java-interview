package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

public class MaximumDepthOfBinaryTree_104 {

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    static void main() {
        // Example from LeetCode: [3,9,20,null,null,15,7]
        Integer[] array = {3, 9, 20, null, null, 15, 7};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(array);

        int depth = maxDepth(root);
        System.out.println("Maximum depth of the tree: " + depth);

        Integer[] array2 = {1, null, 2};
        root = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        depth = maxDepth(root);
        System.out.println("Maximum depth of the tree: " + depth);
    }
}
