package com.example.tree.treefundamentals;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        preorder(root, results);
        return results;
    }

    private void preorder(TreeNode node, List<Integer> results) {
        if (node == null) {
            return;
        }
        results.add(node.val);
        preorder(node.left, results);
        preorder(node.right, results);
    }


    static void main() {
        BinaryTreePreorderTraversal_144 x = new BinaryTreePreorderTraversal_144();

        // Test-1: [1,null,2,3]
        Integer[] array1 = {1, null, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(array1);
        System.out.println(x.preorderTraversal(root1));

        // Test-2: [1,2,3,4,5,null,8,null,null,6,7,9]
        Integer[] array2 = {1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        System.out.println(x.preorderTraversal(root2));

        // Test-3: []
        Integer[] array3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(array3);
        System.out.println(x.preorderTraversal(root3));

        // Test-4 [1]
        Integer[] array4 = {1};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(array4);
        System.out.println(x.preorderTraversal(root4));
    }
}
