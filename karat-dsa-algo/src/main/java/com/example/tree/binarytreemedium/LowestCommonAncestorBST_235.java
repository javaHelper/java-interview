package com.example.tree.binarytreemedium;

import com.example.tree.TreeNode;

public class LowestCommonAncestorBST_235 {
    /**
     * Finds a node with a specific value in the BST.
     */
    public static TreeNode findNode(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val < root.val) return findNode(root.left, val);
        return findNode(root.right, val);
    }

    /**
     * Uses BST property to find LCA recursively.
     *
     * Time Complexity: O(h) where h is tree height
     * Space Complexity: O(h) for recursion stack
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If both nodes are smaller than root, LCA is in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        // If both nodes are greater than root, LCA is in right subtree
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        // Otherwise, root is the LCA (one node is on each side, or root equals p or q)
        else {
            return root;
        }
    }
}
