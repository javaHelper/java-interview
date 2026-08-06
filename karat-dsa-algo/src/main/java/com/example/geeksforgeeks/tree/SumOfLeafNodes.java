package com.example.geeksforgeeks.tree;

public class SumOfLeafNodes {

    public int leafSum(Node root) {
        if (root == null) {
            return 0;
        }

        // If current node is a leaf, return its value
        if (root.left == null && root.right == null) {
            return root.data;
        }

        // Recur for left and right subtrees
        int leftSum = leafSum(root.left);
        int rightSum = leafSum(root.right);
        return leftSum + rightSum;
    }

    static void main() {
        SumOfLeafNodes sol = new SumOfLeafNodes();

        Integer[] arr1 = {3, 1, 2};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println(sol.leafSum(root1));

        Integer[] arr2 = {10, 20, 30, 10, 10, null, null};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println(sol.leafSum(root2));
    }
}
