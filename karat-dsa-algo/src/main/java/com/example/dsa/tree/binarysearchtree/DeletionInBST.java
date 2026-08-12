package com.example.dsa.tree.binarysearchtree;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.geeksforgeeks.tree.BuildTreeLevelOrderArray;
import com.example.geeksforgeeks.tree.Node;

public class DeletionInBST {
    static Node deleteNode(Node root, int x) {
        if (root == null) {
            return root;
        }
        if (root.data < x) {
            root.right = deleteNode(root.right, x);
        } else if (root.data > x) {
            root.left = deleteNode(root.left, x);
        } else {
            // Node with 0 or 1 child
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Node with 2 children
            Node succ = getSuccessor(root);
            root.data = succ.data;
            root.right = deleteNode(root.right, succ.data);
        }
        return root;
    }

    // Get inorder successor (smallest in right subtree)
    static Node getSuccessor(Node curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static void main() {
        Integer[] integer = new Integer[]{
                10,
                5,15,
                null, null, 12,18
                };
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(integer);
        System.out.println(DeletionInBST.deleteNode(root,15));
        BuildLevelOrderArray.printTree(root);
    }
}
