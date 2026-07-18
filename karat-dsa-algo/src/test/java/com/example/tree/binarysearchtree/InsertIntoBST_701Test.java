package com.example.tree.binarysearchtree;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class InsertIntoBST_701Test {
    InsertIntoBST_701 sol = new InsertIntoBST_701();

    @Test
    void InsertIntoBST1(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.insertIntoBST(root, 5);

        System.out.println("Original tree (level order): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void InsertIntoBST2(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.insertIntoBST(null, 10);

        System.out.println("Test 2 (insert into empty tree): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void InsertIntoBST3(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3, 5};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.insertIntoBST(root, 0);

        System.out.println("Test 3 (insert val = 0): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void InsertIntoBST4(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3, 5};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.insertIntoBST(root, 8);

        System.out.println("Test 4 (insert val = 8): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }
}
