package com.example.dsa.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    public ArrayList<Integer> leftViewBFS(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                // First node of this level → part of left view
                if (i == 0) {
                    result.add(currentNode.data);
                }

                // Add children for next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }

    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, 0, result);
        return result;
    }

    private void leftViewHelper(Node node, int level, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }

        // If this is the first time we're visiting this level, add the node
        if (level == result.size()) {
            result.add(node.data);
        }

        // Go left first, then right (pre‑order ensures leftmost is visited first)
        leftViewHelper(node.left, level + 1, result);
        leftViewHelper(node.right, level + 1, result);
    }


    static void main() {
        LeftViewOfBinaryTree sol = new LeftViewOfBinaryTree();

        // Example 1: [1, 2, 3, 4, 5, null, null] → Expected: [1, 2, 4]
        Integer[] arr1 = {1, 2, 3, 4, 5, null, null};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Left view: " + sol.leftView(root1));   // [1, 2, 4]

        // Example 2: [1, 2, 3, null, null, 4, null, null, 5] → Expected: [1, 2, 4, 5]
        Integer[] arr2 = {1, 2, 3, null, null, 4, null, null, 5};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Left view: " + sol.leftView(root2));   // [1, 2, 4, 5]
    }
}
