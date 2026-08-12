package com.example.geeksforgeeks.tree;

import java.util.ArrayList;
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

    static void printTree(Node root) {
        if (root == null) {
            System.out.print("[]");
            return;
        }

        ArrayList<String> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr == null) {
                ans.add("N");
            } else {
                ans.add(String.valueOf(curr.data));
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }

        // Remove trailing N's
        while (!ans.isEmpty() && ans.get(ans.size() - 1).equals("N")) {
            ans.remove(ans.size() - 1);
        }

        System.out.print("[");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i + 1 < ans.size()) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
