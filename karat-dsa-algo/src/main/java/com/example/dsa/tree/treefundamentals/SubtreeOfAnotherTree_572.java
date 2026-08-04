package com.example.dsa.tree.treefundamentals;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.dsa.tree.TreeNode;

public class SubtreeOfAnotherTree_572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // If root is null, no subtree can exist (subRoot is guaranteed non-null per constraints)
        if (root == null) {
            return false;
        }

        // Check if the tree rooted at current node is identical to subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise, recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper: Check if two trees are exactly identical in structure and values
    private boolean isSameTree(TreeNode node1, TreeNode node2) {
        // Both null → identical
        if (node1 == null && node2 == null) {
            return true;
        }

        // One null, the other not → not identical
        if (node1 == null || node2 == null) {
            return false;
        }

        // Values differ → not identical
        if (node1.val != node2.val) {
            return false;
        }

        // Recursively check left and right subtrees
        return isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    static void main() {
        SubtreeOfAnotherTree_572 sol = new SubtreeOfAnotherTree_572();

        // Example 1: root = [3,4,5,1,2], subRoot = [4,1,2]
        // Expected: true (subtree rooted at 4 matches)
        Integer[] rootArr1 = {3, 4, 5, 1, 2};
        Integer[] subRootArr1 = {4, 1, 2};
        TreeNode root1 = BuildLevelOrderArray.buildTreeLevelOrder(rootArr1);
        TreeNode subRoot1 = BuildLevelOrderArray.buildTreeLevelOrder(subRootArr1);
        System.out.println("Example 1: " + sol.isSubtree(root1, subRoot1)); // true

        // Example 2: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
        // Expected: false (the 4 node has an extra child 0, so structure differs)
        Integer[] rootArr2 = {3, 4, 5, 1, 2, null, null, null, null, 0};
        Integer[] subRootArr2 = {4, 1, 2};
        TreeNode root2 = BuildLevelOrderArray.buildTreeLevelOrder(rootArr2);
        TreeNode subRoot2 = BuildLevelOrderArray.buildTreeLevelOrder(subRootArr2);
        System.out.println("Example 2: " + sol.isSubtree(root2, subRoot2)); // false

        // Example 3: root = [1,2,3,4,5], subRoot = [2,4,5]
        // Expected: true
        Integer[] rootArr3 = {1, 2, 3, 4, 5};
        Integer[] subRootArr3 = {2, 4, 5};
        TreeNode root3 = BuildLevelOrderArray.buildTreeLevelOrder(rootArr3);
        TreeNode subRoot3 = BuildLevelOrderArray.buildTreeLevelOrder(subRootArr3);
        System.out.println("Example 3: " + sol.isSubtree(root3, subRoot3)); // true

        // Example 4: root = [1,2,3,4,5,null,null,6], subRoot = [2,4,5]
        // Expected: false (the 2 node has an extra child 6, so structure differs)
        Integer[] rootArr4 = {1, 2, 3, 4, 5, null, null, 6};
        Integer[] subRootArr4 = {2, 4, 5};
        TreeNode root4 = BuildLevelOrderArray.buildTreeLevelOrder(rootArr4);
        TreeNode subRoot4 = BuildLevelOrderArray.buildTreeLevelOrder(subRootArr4);
        System.out.println("Example 4: " + sol.isSubtree(root4, subRoot4)); // false
    }
}
