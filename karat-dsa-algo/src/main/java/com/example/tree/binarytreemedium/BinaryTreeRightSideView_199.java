package com.example.tree.binarytreemedium;

import com.example.tree.treefundamentals.BuildLevelOrderArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

    // ==================== BFS (LEVEL-ORDER) SOLUTION ====================
    /**
     * Returns the right side view using BFS.
     * At each level, we take the last node's value.
     * Time: O(n)  |  Space: O(w) — where w is the maximum width of the tree.
     */
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Process the entire level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                // If this is the last node of the level, add its value
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
                // Add children for next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    // ==================== DFS (RIGHT-FIRST) SOLUTION ====================
    /**
     * Returns the right side view using recursive DFS.
     * We traverse right subtree first, then left.
     * The first node we visit at each depth is the rightmost node.
     * Time: O(n)  |  Space: O(h) — recursion stack (h = tree height).
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        // If this is the first time we visit this depth, add the current node.
        // Because we go right first, it will be the rightmost node.
        if (depth == result.size()) {
            result.add(node.val);
        }

        // Traverse right first, then left
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        BinaryTreeRightSideView_199 solution = new BinaryTreeRightSideView_199();

        // Test case 1: [1,2,3,null,5,null,4] → Expected: [1,3,4]
        Integer[] arr1 = {1, 2, 3, null, 5, null, 4};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Test 1 (BFS): " + solution.rightSideViewBFS(root1));
        System.out.println("Test 1 (DFS): " + solution.rightSideViewDFS(root1));

        // Test case 2: [1,null,3] → Expected: [1,3]
        Integer[] arr2 = {1, null, 3};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 2 (BFS): " + solution.rightSideViewBFS(root2));
        System.out.println("Test 2 (DFS): " + solution.rightSideViewDFS(root2));

        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        System.out.println("Test 3 (BFS): " + solution.rightSideViewBFS(root3));
        System.out.println("Test 3 (DFS): " + solution.rightSideViewDFS(root3));

        // Test case 4: [1,2,3,4] → Expected: [1,3,4]
        Integer[] arr4 = {1, 2, 3, 4};
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 4 (BFS): " + solution.rightSideViewBFS(root4));
        System.out.println("Test 4 (DFS): " + solution.rightSideViewDFS(root4));
    }
}