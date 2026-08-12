package com.example.dsa.tree.binarysearchtree;

import com.example.dsa.tree.BuildLevelOrderArray;
import com.example.geeksforgeeks.tree.BuildTreeLevelOrderArray;
import com.example.geeksforgeeks.tree.Node;

public class InsertionInBST {
    static Node insert(Node root, int key) {

        // If tree is empty, create a new node
        if (root == null) {
            return new Node(key);
        }

        // Insert into the left subtree
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else if(key > root.data){
            root.right = insert(root.right, key);
        }
        return root;
    }



    static void main() {
        Integer[] integers = {22,
                12, 30,
                8, 20, null, null,
                null,null, null, 21};
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(integers);
        System.out.println(InsertionInBST.insert(root, 15));
        BuildLevelOrderArray.printTree(root);
    }
}
