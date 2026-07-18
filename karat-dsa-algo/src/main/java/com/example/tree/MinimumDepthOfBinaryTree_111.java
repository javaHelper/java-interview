package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree_111 {
    public int minDepthBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // First leaf encountered → return current depth
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // Leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Only left child exists
        if (root.left == null) {
            return minDepthDFS(root.right) + 1;
        }

        // Only right child exists
        if (root.right == null) {
            return minDepthDFS(root.left) + 1;
        }

        // Both children exist
        return Math.min(minDepthDFS(root.left), minDepthDFS(root.right)) + 1;
    }

    static void main() {
        MinimumDepthOfBinaryTree_111 solution = new MinimumDepthOfBinaryTree_111();
        // ---------- Test Case 1 ----------
        // Array: [3,9,20,null,null,15,7]
        // Expected minimum depth = 2 (path 3 -> 9)
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Test 1 (BFS): " + solution.minDepthBFS(root1)); // 2
        System.out.println("Test 1 (DFS): " + solution.minDepthDFS(root1)); // 2

        // ---------- Test Case 2 ----------
        // Skewed tree: [2,null,3,null,4,null,5,null,6]
        // Expected = 5 (only leaf is 6)
        Integer[] arr2 = {2, null, 3, null, 4, null, 5, null, 6};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 2 (BFS): " + solution.minDepthBFS(root2)); // 5
        System.out.println("Test 2 (DFS): " + solution.minDepthDFS(root2)); // 5

        // ---------- Test Case 3 ----------
        // Empty tree
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        System.out.println("Test 3 (BFS): " + solution.minDepthBFS(root3)); // 0
        System.out.println("Test 3 (DFS): " + solution.minDepthDFS(root3)); // 0

        // ---------- Test Case 4 ----------
        // Single node: [1]
        Integer[] arr4 = {1};
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 4 (BFS): " + solution.minDepthBFS(root4)); // 1
        System.out.println("Test 4 (DFS): " + solution.minDepthDFS(root4)); // 1
    }
}
