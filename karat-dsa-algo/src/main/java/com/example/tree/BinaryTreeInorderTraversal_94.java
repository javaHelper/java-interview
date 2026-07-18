package com.example.tree;

import java.util.*;

/**
 * inorder:  left subtree --> root -> right subtree
 * preorder: root --> left subtree --> right subtree
 * post order: left subtree --> right subtree --> root
 */
public class BinaryTreeInorderTraversal_94 {

    // ---------- The required solution ----------
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null)
            return;

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    // Test the solution with the two provided examples
    public static void main(String[] args) {
        BinaryTreeInorderTraversal_94 solution = new BinaryTreeInorderTraversal_94();

        // Example 1: [1,null,2,3]  -> expected [1,3,2]
        Integer[] arr1 = {1, null, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTree(arr1);
        System.out.println("Inorder of [1,null,2,3]   : " + solution.inorderTraversal(root1));

        // Example 2: [1,2,3,4,5,null,8,null,null,6,7,9] -> expected [4,2,6,5,7,1,3,9,8]
        Integer[] arr2 = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode root2 = BuildLevelOrderArray.buildTree(arr2);
        System.out.println("Inorder of [1,2,3,4,5,null,8,null,null,6,7,9] : " + solution.inorderTraversal(root2));
    }
}