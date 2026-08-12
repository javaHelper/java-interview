package com.example.geeksforgeeks.tree;

import com.example.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfTree {

    // Returns the height of the tree
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1 + Math.max(left, right);
    }

    // Counts nodes at the given level
    public int getWidth(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }

        if (level == 1) {
            return 1;
        }

        return getWidth(root.left, level - 1) +
                getWidth(root.right, level - 1);
    }

    public int maxWidthUsingRecursion(TreeNode root){
        int h = height(root);
        int ans = 0;

        for (int i = 1; i <= h; i++) {
            ans = Math.max(ans, getWidth(root, i));
        }

        return ans;
    }

    public int maxWidth(Node root) {
        // Base case: empty tree has width 0
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            // Update the maximum width found so far
            maxWidth = Math.max(maxWidth, levelSize);

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                // Add the children of the current node for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }

        return maxWidth;
    }

    static void main() {
        MaximumWidthOfTree m = new MaximumWidthOfTree();

        // Example 1: [1, 2, 3, 4, 5, 6, 7] → Expected: 4
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Max width: " + m.maxWidth(root1)); // 4
    }
}
