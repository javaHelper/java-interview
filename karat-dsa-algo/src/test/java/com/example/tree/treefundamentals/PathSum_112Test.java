package com.example.tree.treefundamentals;

import com.example.tree.binarytreemedium.PathSum_112;
import com.example.tree.binarytreemedium.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathSum_112Test {
    PathSum_112 pathSum = new PathSum_112();
    TreeNode root = null;

    @BeforeEach
    void beforeEach() {
        // Your original tree in level‑order (LeetCode style)
        Integer[] treeValues = {
                5,
                4, 8,
                11, null, 13, 4,
                7, 2, null, null, null, 1
        };

        // Build the tree dynamically
        root = BuildLevelOrderArray.buildTree(treeValues);
    }


    @Test
    void pathSum1() {
        int target = 22;
        boolean expected = false;

        boolean res = pathSum.hasPathSum(root, target);
        assertThat(res).isTrue();
    }
}
