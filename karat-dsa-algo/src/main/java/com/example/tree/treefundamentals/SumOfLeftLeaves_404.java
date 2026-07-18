package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeavesRecursive(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int sum = 0;

            // Check if the left child exists and is a leaf
            if (root.left != null && root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }

            // Recursively process left and right subtrees
            sum += sumOfLeftLeavesRecursive(root.left);
            sum += sumOfLeftLeavesRecursive(root.right);

            return sum;
    }

    public int sumOfLeftLeavesBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // Check if left child exists and is a leaf
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }

            // Add right child to queue if it exists (right leaves are not counted)
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return sum;
    }

    static void main() {
        SumOfLeftLeaves_404 solution = new SumOfLeftLeaves_404();

        // Test case 1: [3,9,20,null,null,15,7] → Expected: 24 (left leaves: 9 and 15)
        Integer[] array1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(array1);
        System.out.println("Test 1 (Recursive): " + solution.sumOfLeftLeavesRecursive(root1));
        System.out.println("Test 1 (BFS):       " + solution.sumOfLeftLeavesBFS(root1));
        System.out.println("-------------------------------");

        // Test case 2: [1] → Expected: 0 (no left leaf)
        Integer[] array2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        System.out.println("Test 2 (Recursive): " + solution.sumOfLeftLeavesRecursive(root2));
        System.out.println("Test 2 (BFS):       " + solution.sumOfLeftLeavesBFS(root2));
        System.out.println("-------------------------------");

        // Test case 3: [1,2,3,4,5]
        // Tree:   1
        //        / \
        //       2   3
        //      / \
        //     4   5
        // Left leaves: 4 only → Expected: 4
        Integer[] array3 = {1, 2, 3, 4, 5};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(array3);
        System.out.println("Test 3 (Recursive): " + solution.sumOfLeftLeavesRecursive(root3));
        System.out.println("Test 3 (BFS):       " + solution.sumOfLeftLeavesBFS(root3));
        System.out.println("-------------------------------");

        // Test case 4: [] → Expected: 0
        Integer[] array4 = {};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(array4);
        System.out.println("Test 4 (Recursive): " + solution.sumOfLeftLeavesRecursive(root4));
        System.out.println("Test 4 (BFS):       " + solution.sumOfLeftLeavesBFS(root4));
        System.out.println("-------------------------------");
    }
}
