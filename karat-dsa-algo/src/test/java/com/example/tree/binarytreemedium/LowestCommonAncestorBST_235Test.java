package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LowestCommonAncestorBST_235Test {
    LowestCommonAncestorBST_235 sol = new LowestCommonAncestorBST_235();

    @Test
    void LowestCommonAncestorBinarySearchTree1(){
        Integer[] arr1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        TreeNode p1 = sol.findNode(root, 2);
        TreeNode q1 = sol.findNode(root, 8);

        TreeNode treeNode = sol.lowestCommonAncestor(root, p1, q1);

        assertThat(treeNode.val).isEqualTo(6);
    }

    @Test
    void LowestCommonAncestorBinarySearchTree2(){
        Integer[] arr1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        TreeNode p1 = sol.findNode(root, 2);
        TreeNode q1 = sol.findNode(root, 4);

        TreeNode treeNode = sol.lowestCommonAncestor(root, p1, q1);

        assertThat(treeNode.val).isEqualTo(2);
    }

    @Test
    void LowestCommonAncestorBinarySearchTree3(){
        Integer[] arr1 = {2,1};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        TreeNode p1 = sol.findNode(root, 2);
        TreeNode q1 = sol.findNode(root, 1);

        TreeNode treeNode = sol.lowestCommonAncestor(root, p1, q1);

        assertThat(treeNode.val).isEqualTo(2);
    }

    @Test
    void LowestCommonAncestorBinarySearchTree4(){
        Integer[] arr1 = {6, 2, 8, 0, 4, 7, 9, null, null, 3, 5};
        TreeNode root = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        TreeNode p1 = sol.findNode(root, 3);
        TreeNode q1 = sol.findNode(root, 5);

        TreeNode treeNode = sol.lowestCommonAncestor(root, p1, q1);

        assertThat(treeNode.val).isEqualTo(4);
    }
}
