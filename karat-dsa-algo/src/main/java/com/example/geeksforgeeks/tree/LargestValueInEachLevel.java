package com.example.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LargestValueInEachLevel {

    public ArrayList<Integer> largestValues(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int maxVal = Integer.MIN_VALUE;

            // Process all nodes at the current level
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                maxVal = Math.max(maxVal, currentNode.data);

                // Add children for the next level
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(maxVal);
        }
        return result;
    }

    static void main() {
        LargestValueInEachLevel sol = new LargestValueInEachLevel();

        // Example 1: [1, 2, 3] → Expected: [1, 3]
        Integer[] arr1 = {1, 2, 3};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Largest values: " + sol.largestValues(root1)); // [1, 3]

        // Example 2: [4, 9, 2, 3, 5, null, 7] → Expected: [4, 9, 7]
        Integer[] arr2 = {4, 9, 2, 3, 5, null, 7};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println("Largest values: " + sol.largestValues(root2)); // [4, 9, 7]

        // Example 3: [1, 2, 3, 4, 5, 6, 7] → Expected: [1, 3, 7]
        Integer[] arr3 = {1, 2, 3, 4, 5, 6, 7};
        Node root3 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr3);
        System.out.println("Largest values: " + sol.largestValues(root3)); // [1, 3, 7]
    }
}
