package com.example.geeksforgeeks.tree;

public class MinimumInBST {
    int minValue(Node root) {
        // If tree is empty, return -1 as per problem statement[reference:0]
        if (root == null) {
            return -1;
        }

        // Keep going left until we reach the leftmost node
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }

    int minValueRecursive(Node root) {
        // Base case: empty tree
        if (root == null) {
            return -1;
        }
        // If no left child, this is the minimum node
        if (root.left == null) {
            return root.data;
        }
        // Otherwise, continue searching in the left subtree
        return minValueRecursive(root.left);
    }


    static void main() {
        MinimumInBST sol = new MinimumInBST();

        Integer[] arr1 = {5, 4, 6, 3, null, null, 7, 1};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Minimum in Tree 1: " + sol.minValue(root1));    // Expected: 1
        System.out.println("Minimum (Recursive): " + sol.minValueRecursive(root1)); // Expected: 1
    }
}
