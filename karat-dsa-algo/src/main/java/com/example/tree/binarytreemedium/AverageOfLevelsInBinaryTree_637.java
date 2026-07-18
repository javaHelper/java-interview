package com.example.tree.binarytreemedium;

import com.example.tree.treefundamentals.BuildLevelOrderArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Main solution class for LeetCode 637 - Average of Levels in Binary Tree.
 */
public class AverageOfLevelsInBinaryTree_637 {

    /**
     * Returns the average value of nodes at each level using BFS.
     * 
     * Time: O(n) — each node is visited once.
     * Space: O(w) — where w is the maximum width of the tree (queue storage).
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();   // number of nodes at current level
            double sum = 0;                 // use double to avoid integer division

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                // Add children for the next level
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // Calculate average for this level
            result.add(sum / levelSize);
        }
        return result;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree_637 solution = new AverageOfLevelsInBinaryTree_637();

        // Test case 1: [3,9,20,null,null,15,7] → Expected: [3.0, 14.5, 11.0]
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Test 1: " + solution.averageOfLevels(root1));

        // Test case 2: [1] → Expected: [1.0]
        Integer[] arr2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 2: " + solution.averageOfLevels(root2));

        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        System.out.println("Test 3: " + solution.averageOfLevels(root3));

        // Test case 4: [1,2,3,4,5,6,7] → Expected: [1.0, 2.5, 5.5]
        Integer[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 4: " + solution.averageOfLevels(root4));
    }
}