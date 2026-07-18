package com.example.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildLevelOrderArray {
    public static TreeNode buildTree(Integer[] arr) {
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
}
