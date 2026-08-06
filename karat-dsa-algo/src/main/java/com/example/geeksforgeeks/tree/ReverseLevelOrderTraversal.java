package com.example.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    public ArrayList<Integer> reverseLevelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.offer(root);

        // Normal level‑order traversal, pushing nodes onto a stack
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            stack.push(current);

            // Enqueue right child first, then left child
            // This ensures that when we pop from the stack, left appears before right
            if (current.right != null) queue.offer(current.right);
            if (current.left != null) queue.offer(current.left);
        }

        // Pop from stack to get reverse level order
        while (!stack.isEmpty()) {
            result.add(stack.pop().data);
        }
        return result;
    }

    static void main() {
        ReverseLevelOrderTraversal sol = new ReverseLevelOrderTraversal();

        // Test Case 1: root = [1, 3, 2]
        // Tree:
        //     1
        //    / \
        //   3   2
        Integer[] arr1 = {1, 3, 2};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder((arr1));
        System.out.println("Reverse Level Order: " + sol.reverseLevelOrder(root1));
        // Expected: [3, 2, 1]
    }
}
