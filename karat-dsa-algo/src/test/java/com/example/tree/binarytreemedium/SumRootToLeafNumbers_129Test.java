package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class SumRootToLeafNumbers_129Test {
    SumRootToLeafNumbers_129 sol = new SumRootToLeafNumbers_129();

    @Test
    void SumRootToLeafNumbers1() {
        // Test Case 1:
        // Tree: [1, 2, 3]
        // Paths: 1->2 = 12, 1->3 = 13
        // Expected: 25
        Integer[] arr1 = {1, 2, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int sumNumbers = sol.sumNumbers(root1);
        System.out.println("Test 1 (root = [1,2,3]):" + sumNumbers);
    }

    @Test
    void SumRootToLeafNumbers2() {
        // Test Case 2:
        // Tree: [4, 9, 0, 5, 1]
        // Paths: 4->9->5 = 495, 4->9->1 = 491, 4->0 = 40
        // Expected: 1026
        Integer[] arr2 = {4, 9, 0, 5, 1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        int sumNumbers = sol.sumNumbers(root2);
        System.out.println("Test 3 (root = [1,2,3,4,5]):" + sumNumbers);
    }

    @Test
    void SumRootToLeafNumbers3() {
        // Test Case 3:
        // Tree: [1, 2, 3, 4, 5]
        // Paths: 1->2->4 = 124, 1->2->5 = 125, 1->3 = 13
        // Expected: 262
        Integer[] arr3 = {1, 2, 3, 4, 5};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        int sumNumbers = sol.sumNumbers(root3);
        System.out.println("Test 3 (root = [1,2,3,4,5]):" + sumNumbers);
    }


    @Test
    void SumRootToLeafNumbers4() {
        // Test Case 4: Single node
        // Tree: [5]
        // Path: 5 = 5
        // Expected: 5
        Integer[] arr3 = { 5};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);
        int sumNumbers = sol.sumNumbers(root3);
        System.out.println("Test 4 (root = [5]):" + sumNumbers);
    }
}
