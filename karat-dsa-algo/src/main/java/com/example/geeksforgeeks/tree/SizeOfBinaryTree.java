package com.example.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfBinaryTree {

    public int getSizeBFS(Node root) {
        // base case
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count++;

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return count;
    }

    static void main() {
        SizeOfBinaryTree sol = new SizeOfBinaryTree();

        Integer[] arr1 = {5, 1, 6, 3, null, 7, 4};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Size of tree 1: " + sol.getSizeBFS(root1));  // Output: 6

        Integer[] arr2 = {1, 2, 3};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Size of tree 2: " + sol.getSizeBFS(root2));  // Output: 3

        Integer[] arr3 = {5, 1, 6, 3, 7, 4};
        Node root3 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Size of tree 3: " + sol.getSizeBFS(root3));  // Output: 6
    }
}
