package com.example.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree {

    public int height(Node root) {
        // Base case - empty tree has height -1
        if (root == null) {
            return -1;
        }
        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }

    public int heightUsingBFS(Node root) {
        if (root == null) {
            return -1;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        int height = -1;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            height++;

            for (int i = 0; i < levelSize; i++) {
                Node node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return height;
    }

    static void main() {
        HeightOfBinaryTree sol = new HeightOfBinaryTree();

        // Example 1: [12, 8, 18, 5, 11] → Expected: 2
        Integer[] arr1 = {12, 8, 18, 5, 11};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Height of tree 1: " + sol.height(root1)); // 2
        System.out.println("Height of tree 1: " + sol.heightUsingBFS(root1)); // 2
        System.out.println("-----------------------------------");

        // Example 2: [1, 2, 3, 4, null, 10, 5, null, null, null, null, 6, 7] → Expected: 3
        Integer[] arr2 = {1, 2, 3, 4, null, 10, 5, null, null, null, null, 6, 7};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Height of tree 2: " + sol.height(root2)); // 3

        // Example 3: single node [1] → Expected: 0
        Integer[] arr3 = {1};
        Node root3 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Height of tree 3: " + sol.height(root3)); // 0

        // Example 4: empty tree [] → Expected: -1
        Integer[] arr4 = {};
        Node root4 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr4);
        System.out.println("Height of tree 4: " + sol.height(root4)); // -1
    }
}
