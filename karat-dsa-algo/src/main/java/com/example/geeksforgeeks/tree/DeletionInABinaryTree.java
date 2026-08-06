package com.example.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletionInABinaryTree {

    public Node deletion(Node root, int key) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            return (root.data == key) ? null : root;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node keyNode = null;
        Node deepestNode = null;

        while (!queue.isEmpty()) {
            deepestNode = queue.poll();
            if (deepestNode.data == key) keyNode = deepestNode;
            if (deepestNode.left != null) queue.offer(deepestNode.left);
            if (deepestNode.right != null) queue.offer(deepestNode.right);
        }

        if (keyNode != null) {
            keyNode.data = deepestNode.data;
            deleteDeepest(root, deepestNode);
        }

        return root;
    }

    private void deleteDeepest(Node root, Node target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.right != null) {
                if (current.right == target) {
                    current.right = null;
                    return;
                }
                queue.offer(current.right);
            }
            if (current.left != null) {
                if (current.left == target) {
                    current.left = null;
                    return;
                }
                queue.offer(current.left);
            }
        }
    }
}
