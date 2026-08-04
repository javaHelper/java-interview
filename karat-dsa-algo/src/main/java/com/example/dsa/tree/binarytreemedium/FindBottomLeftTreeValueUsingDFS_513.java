package com.example.dsa.tree.binarytreemedium;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

public class FindBottomLeftTreeValueUsingDFS_513 {
    private int maxDepth = -1;
    private int answer = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return answer;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            answer = node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    static void main() {
        FindBottomLeftTreeValueUsingDFS_513 sol = new FindBottomLeftTreeValueUsingDFS_513();

        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println(sol.findBottomLeftValue(root1)); // 1
        System.out.println();
    }
}
