package com.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at current level[reference:0]
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // Add children to queue for next level[reference:1]
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal_102 solution = new BinaryTreeLevelOrderTraversal_102();

        // Test case 1: [3,9,20,null,null,15,7] → Expected: [[3],[9,20],[15,7]][reference:2]
        Integer[] array1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTree(array1);
        System.out.println("Test 1: " + solution.levelOrder(root1));

        // Test case 2: [1] → Expected: [[1]][reference:3]
        Integer[] array2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTree(array2);
        System.out.println("Test 2: " + solution.levelOrder(root2));

        // Test case 3: [] → Expected: [][reference:4]
        Integer[] array3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTree(array3);
        System.out.println("Test 3: " + solution.levelOrder(root3));
    }
}
