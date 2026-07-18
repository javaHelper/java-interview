package com.example.tree.binarysearchtree;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class SearchInBST_700Test {
    SearchInBST_700 sol = new SearchInBST_700();

    @Test
    void SearchInBST(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.searchBST(root, 2);
        System.out.println("Original tree (level order): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void SearchInBST2(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.searchBST(root, 5);
        System.out.println("Test 2 (search for val = 5): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void SearchInBST3(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.searchBST(root, 7);
        System.out.println("Test 3 (search for val = 7): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }

    @Test
    void SearchInBST34(){
        // Build the tree: [4, 2, 7, 1, 3]
        Integer[] arr = {4, 2, 7, 1, 3};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        TreeNode treeNode = sol.searchBST(null , 10);
        System.out.println("Test 4 (search for val = 10 in empty tree): " + sol.levelOrderTraversal(treeNode));
        System.out.println();
    }
}
