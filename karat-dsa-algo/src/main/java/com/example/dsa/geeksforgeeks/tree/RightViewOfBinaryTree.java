package com.example.dsa.geeksforgeeks.tree;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        rightViewHelper(root, 0, result);
        return result;
    }

    private void rightViewHelper(Node node, int level, ArrayList<Integer> result) {
        if (node == null) {
            return;
        }
        // If this is the first time we're visiting this level, add the node
        if (level == result.size()) {
            result.add(node.data);
        }

        // Go right first, then left
        rightViewHelper(node.right, level + 1, result);
        rightViewHelper(node.left, level + 1, result);
    }

    static void main() {
        RightViewOfBinaryTree sol = new RightViewOfBinaryTree();

        // Example 1: [1, 2, 3, null, null, 4, 5] → Expected: [1, 3, 5]
        Integer[] arr1 = {1, 2, 3, null, null, 4, 5};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("Right view (BFS): " + sol.rightView(root1));    // [1, 3, 5]
    }
}
