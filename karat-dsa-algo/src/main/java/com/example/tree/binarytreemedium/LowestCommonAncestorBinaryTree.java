package com.example.tree.binarytreemedium;

import com.example.tree.TreeNode;

import java.util.Arrays;

public class LowestCommonAncestorBinaryTree {
    /**
     * Builds the tree by copying subarrays.
     * <p>
     * Time Complexity: O(n²) - array copying at each recursive level
     * Space Complexity: O(n²) - new arrays created at each level
     * <p>
     * This is easier to understand but less efficient than the HashMap approach.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        // First element of preorder is the root
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // Left subtree: elements before root in inorder
        // Corresponding portion in preorder: after root, up to leftSize elements
        int leftSize = rootIndex;
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        root.left = buildTree(leftPreorder, leftInorder);

        // Right subtree: elements after root in inorder
        int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + leftSize, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }
}
