package com.example.tree.binarysearchtree;

import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchInBST_700 {
    /**
     * Uses BST property to search recursively.
     * - If root is null or root.val == val, return root
     * - If val < root.val, search in left subtree
     * - If val > root.val, search in right subtree
     *
     * Time Complexity: O(h) where h is tree height
     * Space Complexity: O(h) for recursion stack
     */
    public TreeNode searchBST(TreeNode root, int val) {
        // Base case: empty tree or found the value
        if (root == null || root.val == val) {
            return root;
        }

        // BST property: if val is smaller, go left; otherwise go right
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    // ---------- UTILITY: PRINT TREE (Level Order) for Verification ----------
    public List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        // Remove trailing nulls for cleaner output
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }
        return result;
    }
}
