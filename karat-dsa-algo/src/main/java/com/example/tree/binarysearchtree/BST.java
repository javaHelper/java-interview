package com.example.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int val) {
            this.data = val;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null)
            return false;

        if (root.data > key) { // left subtree
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root == null) return null;  // optional safety check

        if (root.data > val) {
            root.left = delete(root.left, val);   // ← fixed
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else {
            // Case 1: leaf
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: two children
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y) {
        if (root == null) {
            return;
        }

        if (root.data >= x && root.data <= y) {
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        } else if (root.data >= y) {
            printInRange(root.left, x, y);
        } else {
            printInRange(root.right, x, y);
        }
    }

    public static void printRoot2Leaf(Node root, List<Integer> path) {
        if (root == null) {
            return;
        }

        path.add(root.data);

        //leaf
        if (root.left == null && root.right == null) {
            printPath(path);
        } else { // non-leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    private static void printPath(List<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }


    static void main() {
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 7)) {
            System.out.println("found");
        } else {
            System.out.println("Not found");
        }

        System.out.println("\n------Delete -----");
        delete(root, 4);
        inorder(root);

        System.out.println("\n------Delete -----");
        delete(root, 5);
        inorder(root);

        System.out.println("\n---------------------");
        printInRange(root, 6, 10);

        System.out.println("\n---------------------");
        printInRange(root, 3, 12);

        System.out.println("\n======================");
        test();

    }

    public static void test(){
        int[] values = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        printRoot2Leaf(root, new ArrayList<>());
    }
}
