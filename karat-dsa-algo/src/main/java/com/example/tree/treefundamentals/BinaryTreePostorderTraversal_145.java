package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Preorder Traversal (Root → Left → Right)
 * Inorder Traversal (Left → Root → Right)
 * Postorder Traversal (Left → Right → Root)
 */
public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        postorder(root, results);
        return results;
    }

    private void postorder(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }
        postorder(node.left, results);
        postorder(node.right, results);
        results.add(node.val);
    }

    static void main() {
        BinaryTreePostorderTraversal_145 x = new BinaryTreePostorderTraversal_145();

        // Test-1: [1,null,2,3]  → Expected: [3,2,1]
        Integer[] array1 = {1, null, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(array1);
        System.out.println(x.postorderTraversal(root1));   // [3, 2, 1]

        // Test-2: [1,2,3,4,5,null,8,null,null,6,7,9]
        Integer[] array2 = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        System.out.println(x.postorderTraversal(root2));   // [4, 6, 7, 5, 2, 9, 8, 3, 1]

        // Test-3: []  → Expected: []
        Integer[] array3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(array3);
        System.out.println(x.postorderTraversal(root3));   // []

        // Test-4: [1]  → Expected: [1]
        Integer[] array4 = {1};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(array4);
        System.out.println(x.postorderTraversal(root4));   // [1]
    }
}
