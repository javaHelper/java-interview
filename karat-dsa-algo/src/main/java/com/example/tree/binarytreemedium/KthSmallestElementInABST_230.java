package com.example.tree.binarytreemedium;

import com.example.tree.TreeNode;

public class KthSmallestElementInABST_230 {
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null || count == 0) return;

        // Visit left subtree
        inorder(node.left);

        // Visit current node
        count--;
        if (count == 0) {
            result = node.val;
            return;
        }

        // Visit right subtree
        inorder(node.right);
    }
}
