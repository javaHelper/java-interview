package com.example.geeksforgeeks.tree;

public class BSTInsert {

    public Node insert(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            return new Node(key);
        }

        // Otherwise, recur down the tree
        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        // If key == root.data, we do nothing (no duplicates allowed)

        return root;
    }

    static void main() {
        BSTInsert x = new BSTInsert();
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(new Integer[]{2, 1, 3});
        System.out.print("BST before insertion: ");
        x.inorder(root);
        System.out.println();

        // Insert a new key
        int keyToInsert = 4;
        root = x.insert(root, keyToInsert);

        System.out.print("BST after inserting => " + keyToInsert + ": ");
        x.inorder(root);  // Output: 1 2 3 4
        System.out.println();
    }

    // Helper method to print inorder traversal (sorted order)
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}
