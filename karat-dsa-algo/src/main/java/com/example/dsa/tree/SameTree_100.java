package com.example.dsa.tree;

public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Step 1: Both nodes are null → identical
        if (p == null && q == null) {
            return true;
        }

        // Step 2: One is null, the other is not → not identical
        if (p == null || q == null) {
            return false;
        }

        // Step 3: Values differ → not identical
        if (p.val != q.val) {
            return false;
        }

        // Step 4: Recursively compare left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    static void main() {
        SameTree_100 s = new SameTree_100();
        TreeNode p1 = BuildLevelOrderArray.buildTreeLevelOrder(new Integer[]{1, 2, 3});
        TreeNode q1 = BuildLevelOrderArray.buildTreeLevelOrder(new Integer[]{1, 2, 3});
        System.out.println("Test 1: " + s.isSameTree(p1, q1)); // Expected: true
    }
}
