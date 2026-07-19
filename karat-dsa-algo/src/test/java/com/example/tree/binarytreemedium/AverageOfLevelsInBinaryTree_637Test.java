package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import com.example.tree.treefundamentals.AverageOfLevelsInBinaryTree_637;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AverageOfLevelsInBinaryTree_637Test {
    AverageOfLevelsInBinaryTree_637 sol = new AverageOfLevelsInBinaryTree_637();

    @Test
    void AverageOfLevelsInBinaryTree1() {
        // Test case 1: [3,9,20,null,null,15,7] → Expected: [3.0, 14.5, 11.0]
        Integer[] arr1 = {3, 9, 20, null, null, 15, 7};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);

        List<Double> res = sol.averageOfLevels(root1);
        System.out.println("Test 1: " + res);
        assertThat(res).containsExactly(3.0, 14.5, 11.0);
    }

    @Test
    void AverageOfLevelsInBinaryTree2() {
        // Test case 2: [1] → Expected: [1.0]
        Integer[] arr2 = {1};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(arr2);

        List<Double> res = sol.averageOfLevels(root2);
        System.out.println("Test 2: " + res);
        assertThat(res).containsExactly(1.0);
    }

    @Test
    void AverageOfLevelsInBinaryTree3() {
        // Test case 3: [] → Expected: []
        Integer[] arr3 = {};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(arr3);

        List<Double> res = sol.averageOfLevels(root3);
        System.out.println("Test 3: " + res);
        assertThat(res).isEmpty();
    }

    @Test
    void AverageOfLevelsInBinaryTree4() {
        // Test case 4: [1,2,3,4,5,6,7] → Expected: [1.0, 2.5, 5.5]
        Integer[] arr4 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(arr4);

        List<Double> res = sol.averageOfLevels(root4);
        System.out.println("Test 4: " + res);
        assertThat(res).containsExactly(1.0, 2.5, 5.5);
    }
}
