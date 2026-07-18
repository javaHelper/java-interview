package com.example.tree.binarytreemedium;

import com.example.tree.TreeNode;

public class SumRootToLeafNumbers_129 {
    /**
     * Uses DFS to traverse the tree. At each node, we update the current number
     * by multiplying the previous number by 10 and adding the current node's value.
     * When we reach a leaf node, we add the current number to the total sum.
     * <p>
     * Time Complexity: O(n) - visits each node once
     * Space Complexity: O(h) - recursion stack, h = tree height
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: empty node
        if (node == null) {
            return 0;
        }

        // Update the current number: append this node's digit
        currentSum = currentSum * 10 + node.val;

        // If leaf node, return the completed number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Recursively process left and right subtrees and sum them
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }
}
