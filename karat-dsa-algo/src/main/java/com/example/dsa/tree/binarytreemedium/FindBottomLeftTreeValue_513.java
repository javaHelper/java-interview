package com.example.dsa.tree.binarytreemedium;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue_513 {
    /**
     * Uses level order traversal. At each level, we record the first node's value.
     * After processing all levels, the last recorded value is the bottom-left value.
     *
     * Time Complexity: O(n) - visits each node once
     * Space Complexity: O(n) - queue can hold up to n/2 nodes at the last level
     */
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0; // Problem guarantees at least one node
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmost = root.val;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Record the first node of this level (leftmost)
            leftmost = queue.peek().val;

            // Process all nodes at current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return leftmost;
    }

    static void main() {
        FindBottomLeftTreeValue_513 sol = new FindBottomLeftTreeValue_513();

        Integer[] arr1 = {2, 1, 3};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println(sol.findBottomLeftValue(root1)); // 1
        System.out.println();
    }
}
