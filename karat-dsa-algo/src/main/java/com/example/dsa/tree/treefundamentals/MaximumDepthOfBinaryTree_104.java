package com.example.dsa.tree.treefundamentals;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_104 {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepthUsingBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 0;

        // Loop until the queue is empty
        while (!q.isEmpty()) {
            int levelSize = q.size();

            // Traverse all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null){
                    q.add(curr.right);
                }
            }
            // Increment height after traversing each level
            depth++;
        }
        return depth - 1;
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
