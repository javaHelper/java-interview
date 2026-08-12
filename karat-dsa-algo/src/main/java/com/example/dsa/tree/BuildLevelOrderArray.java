package com.example.dsa.tree;

import com.example.geeksforgeeks.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BuildLevelOrderArray {



    public static TreeNode buildTreeLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode parent = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                parent.left = new TreeNode(arr[i]);
                queue.offer(parent.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                parent.right = new TreeNode(arr[i]);
                queue.offer(parent.right);
            }
            i++;
        }

        return root;
    }

    public static Node buildStringTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("N")) {
            return null;
        }

        Node root = new Node(Integer.parseInt(arr[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (!arr[i].equals("N")) {
                current.left = new Node(Integer.parseInt(arr[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && !arr[i].equals("N")) {
                current.right = new Node(Integer.parseInt(arr[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }


    public static void printTree(Node root) {
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
