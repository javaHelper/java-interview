package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateBinarySearchTree_98Test {
    ValidateBinarySearchTree_98 sol = new ValidateBinarySearchTree_98();

    @Test
    void ValidateBinarySearchTree1(){
        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 1 (Valid BST): " + validBST); // true
        assertThat(validBST).isTrue();
    }

    @Test
    void ValidateBinarySearchTree2(){
        Integer[] arr1 = {5, 1, 4, null, null, 3, 6};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 2 (Valid BST): " + validBST); // false
        assertThat(validBST).isFalse();
    }

    @Test
    void ValidateBinarySearchTree3(){
        Integer[] arr1 = {};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 3 (Valid BST): " + validBST); // true
        assertThat(validBST).isTrue();
    }

    @Test
    void ValidateBinarySearchTree4(){
        Integer[] arr1 = {10};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 4 (Valid BST): " + validBST); // true
        assertThat(validBST).isTrue();
    }

    @Test
    void ValidateBinarySearchTree5(){
        Integer[] arr1 = {3, 1, 5, null, null, 4, 6};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 5 (Valid BST): " + validBST); // true
        assertThat(validBST).isTrue();
    }

    @Test
    void ValidateBinarySearchTree6(){
        Integer[] arr1 = {1, 1};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        boolean validBST = sol.isValidBST(root1);

        System.out.println("Test 6 (Valid BST): " + validBST); // false
        assertThat(validBST).isFalse();
    }
}
