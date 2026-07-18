package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

public class FindBottomLeftTreeValue_513Test {
    FindBottomLeftTreeValue_513 sol = new FindBottomLeftTreeValue_513();

    @Test
    void FindBottomLeftTreeValue1(){
        // Test Case 1:
        // Tree: [2, 1, 3]
        // Expected: 1
        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int bottomLeftValue = sol.findBottomLeftValue(root1);
        System.out.println("Test 1 (root = [2,1,3]):"+ bottomLeftValue);
    }

    @Test
    void FindBottomLeftTreeValue2(){
        // Test Case 2:
        // Tree: [1, 2, 3, 4, null, 5, 6, null, null, 7]
        // Expected: 7
        Integer[] arr2 = {1, 2, 3, 4, null, 5, 6, null, null, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);
        int bottomLeftValue = sol.findBottomLeftValue(root1);
        System.out.println("Test 2 (root = [1,2,3,4,null,5,6,null,null,7]):"+ bottomLeftValue);
    }

    @Test
    void FindBottomLeftTreeValue3(){
        // Test Case 3:
        // Tree: [0, null, -1]
        // Expected: -1
        Integer[] arr = {0, null, -1};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        int bottomLeftValue = sol.findBottomLeftValue(root1);
        System.out.println("Test 3 (root = [0,null,-1]):"+ bottomLeftValue);
    }

    @Test
    void FindBottomLeftTreeValue4(){
        // Test Case 4: Single node
        // Tree: [5]
        // Expected: 5
        Integer[] arr = {5};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr);
        int bottomLeftValue = sol.findBottomLeftValue(root1);
        System.out.println("Test 4 (root = [5]):"+ bottomLeftValue);
    }
}
