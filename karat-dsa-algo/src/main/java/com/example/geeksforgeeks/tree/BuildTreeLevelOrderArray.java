package com.example.geeksforgeeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTreeLevelOrderArray {

    public static Node buildTreeLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            Node parent = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                parent.left = new Node(arr[i]);
                queue.offer(parent.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                parent.right = new Node(arr[i]);
                queue.offer(parent.right);
            }
            i++;
        }

        return root;
    }
}
