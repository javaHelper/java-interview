package com.example.geeksforgeeks.tree;

public class FloorInBST {

    public int findMaxFork(Node root, int n) {
        int result = -1;
        Node current = root;

        while (current != null) {
            if (current.data == n) {
                return n;  // exact match found
            } else if (current.data < n) {
                // current node is a valid candidate
                result = current.data;
                // move right to find a larger value ≤ n
                current = current.right;
            } else {
                // current node is too large, move left
                current = current.left;
            }
        }

        return result;
    }

    public int findMaxForNRecursive(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return n;
        }
        if (root.data < n) {
            // current node is valid, check if there's a larger valid node on the right
            int rightResult = findMaxForNRecursive(root.right, n);
            return (rightResult != -1) ? rightResult : root.data;
        }
        // root.data > n, search left
        return findMaxForNRecursive(root.left, n);
    }

    static void main() {
        FloorInBST sol = new FloorInBST();

        // Test Case 1: root = [10, 2, 11, 1, 5, null, null, null, null, 3, 6, null, 4]
        // Tree structure:
        //        10
        //       /  \
        //      2    11
        //     / \
        //    1   5
        //       / \
        //      3   6
        //       \
        //        4
        Integer[] arr1 = {10, 2, 11, 1, 5, null, null, null, null, 3, 6, null, 4};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("findMaxForN(root1, 13) = " + sol.findMaxFork(root1, 13)); // Expected: 11
        System.out.println("findMaxForN(root1, 4)  = " + sol.findMaxFork(root1, 4));  // Expected: 4
        System.out.println("findMaxForN(root1, 7)  = " + sol.findMaxFork(root1, 7));  // Expected: 6
        System.out.println("findMaxForN(root1, 0)  = " + sol.findMaxFork(root1, 0));  // Expected: -1
    }
}
