package com.example.tree;

import java.util.Stack;

public class SameTree_100 {
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTreeRecursive(p.left, q.left) &&
                isSameTreeRecursive(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});

        while (!stack.isEmpty()) {
            TreeNode[] pair = stack.pop();
            TreeNode n1 = pair[0], n2 = pair[1];

            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;

            stack.push(new TreeNode[]{n1.left, n2.left});
            stack.push(new TreeNode[]{n1.right, n2.right});
        }
        return true;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        SameTree_100 solution = new SameTree_100();

        // Test case 1: [1,2,3] and [1,2,3] → true
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Test 1 (Recursive): " + solution.isSameTreeRecursive(root1, root2));
        System.out.println("Test 1 (Iterative): " + solution.isSameTreeIterative(root1, root2));

        // Test case 2: [1,2] and [1,null,2] → false
        Integer[] arr3 = {1, 2};
        Integer[] arr4 = {1, null, 2};
        TreeNode root3 = BuildLevelOrderArray.buildTree(arr3);
        TreeNode root4 = BuildLevelOrderArray.buildTree(arr4);
        System.out.println("Test 2 (Recursive): " + solution.isSameTreeRecursive(root3, root4));
        System.out.println("Test 2 (Iterative): " + solution.isSameTreeIterative(root3, root4));

        // Test case 3: [1,2,1] and [1,1,2] → false
        Integer[] arr5 = {1, 2, 1};
        Integer[] arr6 = {1, 1, 2};
        TreeNode root5 = BuildLevelOrderArray.buildTree(arr5);
        TreeNode root6 = BuildLevelOrderArray.buildTree(arr6);
        System.out.println("Test 3 (Recursive): " + solution.isSameTreeRecursive(root5, root6));
        System.out.println("Test 3 (Iterative): " + solution.isSameTreeIterative(root5, root6));

        // Test case 4: [] and [] → true (empty trees)
        Integer[] arr7 = {};
        Integer[] arr8 = {};
        TreeNode root7 = BuildLevelOrderArray.buildTree(arr7);
        TreeNode root8 = BuildLevelOrderArray.buildTree(arr8);
        System.out.println("Test 4 (Recursive): " + solution.isSameTreeRecursive(root7, root8));
        System.out.println("Test 4 (Iterative): " + solution.isSameTreeIterative(root7, root8));

        // Test case 5: [1] and [1] → true
        Integer[] arr9 = {1};
        Integer[] arr10 = {1};
        TreeNode root9 = BuildLevelOrderArray.buildTree(arr9);
        TreeNode root10 = BuildLevelOrderArray.buildTree(arr10);
        System.out.println("Test 5 (Recursive): " + solution.isSameTreeRecursive(root9, root10));
        System.out.println("Test 5 (Iterative): " + solution.isSameTreeIterative(root9, root10));
    }
}
