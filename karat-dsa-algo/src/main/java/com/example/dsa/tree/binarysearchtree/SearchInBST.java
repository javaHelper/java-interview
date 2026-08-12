package com.example.dsa.tree.binarysearchtree;

import com.example.geeksforgeeks.tree.BuildTreeLevelOrderArray;
import com.example.geeksforgeeks.tree.Node;

// https://www.geeksforgeeks.org/dsa/binary-search-tree-set-1-search-and-insertion/
public class SearchInBST {

    /**
     * We compare the value to be searched with the value of the root.
     * If it's equal we are done with the search.
     * If it's smaller we know that we need to go to the left subtree.
     * If it's greater we search in the right subtree.
     */
    static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (key < root.data) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    static void main() {
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(new Integer[]{6, 2, 8, 9, null, null, 7, 9});
        int key = 7;
        System.out.println(SearchInBST.search(root, key));
    }
}
