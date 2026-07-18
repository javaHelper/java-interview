package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII_107 {

    /**
     * Returns the bottom-up level order traversal.
     * 
     * Approach: Perform normal BFS (top-down level order),
     * then reverse the resulting list.
     * 
     * Time: O(n) — each node visited once.
     * Space: O(n) — queue and result list.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }

        // Reverse the list to get bottom-up order
        Collections.reverse(result);
        return result;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII_107 solution = new BinaryTreeLevelOrderTraversalII_107();

        // Test case 1: [3,9,20,null,null,15,7] → Expected: [[15,7],[9,20],[3]]
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Test 1: " + solution.levelOrderBottom(root1));

        // Test case 2: [1] → Expected: [[1]]
        Integer[] arr2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Test 2: " + solution.levelOrderBottom(root2));

        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Test 3: " + solution.levelOrderBottom(root3));

        // Test case 4: [1,2,3,4,5] → Expected: [[4,5],[2,3],[1]]
        Integer[] arr4 = {1, 2, 3, 4, 5};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(arr4);
        System.out.println("Test 4: " + solution.levelOrderBottom(root4));
    }
}