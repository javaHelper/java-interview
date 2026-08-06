package com.example.geeksforgeeks.tree;

public class SumOfLeftLeafNodes {
    public int leftLeavesSum(Node root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        // Check if the left child exists and is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.data;
        }

        // Recursively process left and right subtrees
        sum += leftLeavesSum(root.left);
        sum += leftLeavesSum(root.right);

        return sum;
    }

    static void main() {
        SumOfLeftLeafNodes sol = new SumOfLeftLeafNodes();

        Integer[] arr1 = {1, 2, 3};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println(sol.leftLeavesSum(root1));

        Integer[] arr2 = {1, 2, 3, 4, 5, null, 8, 7, 2 , null, null, 6, 9};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println(sol.leftLeavesSum(root2));
    }
}
