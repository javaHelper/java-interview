package com.example.geeksforgeeks.tree;

public class PerfectBinaryTree {

    boolean isPerfect(Node root) {
        int depth = findDepth(root);
        return checkPerfect(root, 1, depth);
    }

    private boolean checkPerfect(Node root, int level, int depth) {
        // Leaf node
        if (root.left == null && root.right == null) {
            return level == depth;
        }

        // One child only
        if (root.left == null || root.right == null)
            return false;

        return checkPerfect(root.left, level + 1, depth)
                && checkPerfect(root.right, level + 1, depth);
    }

    /**
     * Why is the left path chosen in most solutions?
     * Mostly because it's simple and conventional. In recursive tree problems, traversing the left
     * subtree first is a common pattern.
     */
    private int findDepth(Node root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    static void main() {
        PerfectBinaryTree sol = new PerfectBinaryTree();

        // Example 1: Perfect binary tree [7, 4, 9]
        //       7
        //      / \
        //     4   9
        // Expected: true
        Integer[] arr1 = {7, 4, 9};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Example 1 (Recursive): " + sol.isPerfect(root1));
        // Expected: true, true, true


        // Example 2: Not perfect [7, 3, 8, 2, 5, N, 10, 1, N, N, N, N, N]
        //       7
        //      / \
        //     3   8
        //    / \   \
        //   2   5   10
        //  /
        // 1
        // Expected: false
        Integer[] arr2 = {7, 3, 8, 2, 5, null, 10, 1, null, null, null, null, null};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("\nExample 2 (Recursive): " + sol.isPerfect(root2));
        // Expected: false, false, false
    }
}
