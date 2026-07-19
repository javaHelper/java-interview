package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import com.example.tree.treefundamentals.SumOfLeftLeaves_404;
import org.junit.jupiter.api.Test;

public class SumOfLeftLeaves_404Test {
    SumOfLeftLeaves_404 solution = new SumOfLeftLeaves_404();

    @Test
    void SumOfLeftLeaves1(){
        // Test case 1: [3,9,20,null,null,15,7] → Expected: 24 (left leaves: 9 and 15)
        Integer[] array1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(array1);
        System.out.println("Test 1 (Recursive): " + solution.sumOfLeftLeavesRecursive(root1));
       // System.out.println("Test 1 (BFS):       " + solution.sumOfLeftLeavesBFS(root1));
    }


    @Test
    void SumOfLeftLeaves2(){
        // Test case 2: [1] → Expected: 0 (no left leaf)
        Integer[] array2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(array2);
        System.out.println("Test 2 (Recursive): " + solution.sumOfLeftLeavesRecursive(root2));
       // System.out.println("Test 2 (BFS):       " + solution.sumOfLeftLeavesBFS(root2));
    }

    @Test
    void SumOfLeftLeaves3(){
        Integer[] array3 = {1, 2, 3, 4, 5};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(array3);
        System.out.println("Test 3 (Recursive): " + solution.sumOfLeftLeavesRecursive(root3));
       // System.out.println("Test 3 (BFS):       " + solution.sumOfLeftLeavesBFS(root3));
    }

    @Test
    void SumOfLeftLeaves4(){
        // Test case 4: [] → Expected: 0
        Integer[] array4 = {};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(array4);
        System.out.println("Test 4 (Recursive): " + solution.sumOfLeftLeavesRecursive(root4));
       // System.out.println("Test 4 (BFS):       " + solution.sumOfLeftLeavesBFS(root4));
    }
}
