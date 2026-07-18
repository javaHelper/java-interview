package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths_257 {

    // ==================== RECURSIVE SOLUTION (DFS) ====================
    /**
     * Returns all root-to-leaf paths using recursive DFS.
     * Time: O(n)  |  Space: O(h) — recursion stack (h = tree height)
     * 
     * Uses a helper that builds the path string and adds it to the result
     * when a leaf is reached.
     */
    public List<String> binaryTreePathsRecursive(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        // Append current node value to the path
        if (path.isEmpty()) {
            path = String.valueOf(node.val);
        } else {
            path += "->" + node.val;
        }

        // If leaf, add path to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        // Recurse on children
        if (node.left != null) {
            dfs(node.left, path, result);
        }
        if (node.right != null) {
            dfs(node.right, path, result);
        }
    }

    // ==================== ITERATIVE SOLUTION (Stack) ====================
    /**
     * Returns all root-to-leaf paths using an explicit stack.
     * Each stack entry stores a node and the path string built so far.
     * Time: O(n)  |  Space: O(n) — stack size (worst-case).
     */
    public List<String> binaryTreePathsIterative(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<Object[]> stack = new Stack<>(); // each entry: [TreeNode, String]
        stack.push(new Object[]{root, String.valueOf(root.val)});

        while (!stack.isEmpty()) {
            Object[] entry = stack.pop();
            TreeNode node = (TreeNode) entry[0];
            String path = (String) entry[1];

            if (node.left == null && node.right == null) {
                result.add(path);
                continue;
            }

            if (node.right != null) {
                stack.push(new Object[]{node.right, path + "->" + node.right.val});
            }
            if (node.left != null) {
                stack.push(new Object[]{node.left, path + "->" + node.left.val});
            }
        }

        return result;
    }

    // ==================== MAIN METHOD FOR TESTING ====================
    public static void main(String[] args) {
        BinaryTreePaths_257 solution = new BinaryTreePaths_257();

        // Test case 1: [1,2,3,null,5] → Expected: ["1->2->5", "1->3"]
        Integer[] arr1 = {1, 2, 3, null, 5};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Test 1 (Recursive): " + solution.binaryTreePathsRecursive(root1));
        System.out.println("Test 1 (Iterative): " + solution.binaryTreePathsIterative(root1));

        // Test case 2: [1] → Expected: ["1"]
        Integer[] arr2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Test 2 (Recursive): " + solution.binaryTreePathsRecursive(root2));
        System.out.println("Test 2 (Iterative): " + solution.binaryTreePathsIterative(root2));

        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Test 3 (Recursive): " + solution.binaryTreePathsRecursive(root3));
        System.out.println("Test 3 (Iterative): " + solution.binaryTreePathsIterative(root3));

        // Test case 4: [1,2,3,4,5,6] → Expected: ["1->2->4", "1->2->5", "1->3->6"]
        Integer[] arr4 = {1, 2, 3, 4, 5, 6};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(arr4);
        System.out.println("Test 4 (Recursive): " + solution.binaryTreePathsRecursive(root4));
        System.out.println("Test 4 (Iterative): " + solution.binaryTreePathsIterative(root4));
    }
}