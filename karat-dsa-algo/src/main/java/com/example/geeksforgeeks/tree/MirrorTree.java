package com.example.geeksforgeeks.tree;

public class MirrorTree {
    // ---------- Mirror the tree ----------
    void mirror(Node root) {
        if (root == null) {
            return;
        }
        mirror(root.left);
        mirror(root.right);

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // ---------- Inorder traversal ----------
    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void main() {
        MirrorTree sol = new MirrorTree();

        Integer[] arr = {1, 2, 3, null, null, 4};
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr);

        System.out.print("Inorder before mirror: ");
        sol.inorder(root);
        System.out.println();

        sol.mirror(root);

        System.out.print("Inorder after mirror:  ");
        sol.inorder(root);
        System.out.println();
    }
}
