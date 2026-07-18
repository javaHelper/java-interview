package com.example.tree.binarytreemedium;

import com.example.tree.BuildLevelOrderArray;
import com.example.tree.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestElementInABST_230Test {
    KthSmallestElementInABST_230 sol = new KthSmallestElementInABST_230();

    @Test
    void KthSmallestElementInABST1() {
        Integer[] arr1 = {3, 1, 4, null, 2};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int smallestElement = sol.kthSmallest(root1, 1);
        assertThat(smallestElement).isEqualTo(1);
    }

    @Test
    void KthSmallestElementInABST2() {
        Integer[] arr1 = {3, 1, 4, null, 2};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int smallestElement = sol.kthSmallest(root1, 2);
        assertThat(smallestElement).isEqualTo(2);
    }

    @Test
    void KthSmallestElementInABST3() {
        Integer[] arr1 = {5, 3, 6, 2, 4, null, null, 1};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int smallestElement = sol.kthSmallest(root1, 3);
        assertThat(smallestElement).isEqualTo(3);
    }

    @Test
    void KthSmallestElementInABST4() {
        Integer[] arr1 = {1};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        int smallestElement = sol.kthSmallest(root1, 1);
        assertThat(smallestElement).isEqualTo(1);
    }
}
