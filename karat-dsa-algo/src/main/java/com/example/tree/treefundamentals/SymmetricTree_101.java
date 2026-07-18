package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree_101 {
    // ==================== RECURSIVE SOLUTION ====================

    /**
     * Checks if a tree is symmetric using recursion.
     * Time: O(n)  |  Space: O(h) — recursion stack (h = tree height)
     */
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Both null → symmetric for this pair
        if (t1 == null && t2 == null) return true;
        // One null or values differ → not symmetric
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        // Compare outer children (t1.left with t2.right) and inner children (t1.right with t2.left)
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    // ==================== ITERATIVE SOLUTION (BFS with Queue) ====================

    /**
     * Checks if a tree is symmetric using a queue (level-order comparison).
     * Time: O(n)  |  Space: O(n) — queue holds at most two levels of nodes.
     */
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;

            // Enqueue pairs in mirror order
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }

        return true;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        SymmetricTree_101 solution = new SymmetricTree_101();

        // Test case 1: [1,2,2,3,4,4,3] → true (symmetric)
        Integer[] arr1 = {1, 2, 2, 3, 4, 4, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Test 1 (Recursive): " + solution.isSymmetricRecursive(root1));
        System.out.println("Test 1 (Iterative): " + solution.isSymmetricIterative(root1));

        // Test case 2: [1,2,2,null,3,null,3] → false (asymmetric)
        Integer[] arr2 = {1, 2, 2, null, 3, null, 3};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Test 2 (Recursive): " + solution.isSymmetricRecursive(root2));
        System.out.println("Test 2 (Iterative): " + solution.isSymmetricIterative(root2));

        // Test case 3: [1,2,2,3,null,null,3] → true (symmetric)
        Integer[] arr3 = {1, 2, 2, 3, null, null, 3};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Test 3 (Recursive): " + solution.isSymmetricRecursive(root3));
        System.out.println("Test 3 (Iterative): " + solution.isSymmetricIterative(root3));

        // Test case 4: [] → true (empty tree is symmetric)
        Integer[] arr4 = {};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(arr4);
        System.out.println("Test 4 (Recursive): " + solution.isSymmetricRecursive(root4));
        System.out.println("Test 4 (Iterative): " + solution.isSymmetricIterative(root4));

        // Test case 5: [1] → true (single node is symmetric)
        Integer[] arr5 = {1};
        TreeNode root5 = BuildLevelOrderArray.buildTreeLevelOrder(arr5);
        System.out.println("Test 5 (Recursive): " + solution.isSymmetricRecursive(root5));
        System.out.println("Test 5 (Iterative): " + solution.isSymmetricIterative(root5));
    }
}
