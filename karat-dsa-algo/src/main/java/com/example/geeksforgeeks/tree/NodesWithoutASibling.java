package com.example.geeksforgeeks.tree;

import java.util.ArrayList;
import java.util.Collections;

public class NodesWithoutASibling {

    public ArrayList<Integer> noSibling(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        findNodesWithoutSibling(root, result);

        if (result.isEmpty()) {
            result.add(-1);
            return result;
        }
        Collections.sort(result);
        return result;
    }

    private void findNodesWithoutSibling(Node node, ArrayList<Integer> result) {
        if (node == null) return;

        if (node.left != null && node.right == null) {
            result.add(node.left.data);
        } else if (node.right != null && node.left == null) {
            result.add(node.right.data);
        }

        findNodesWithoutSibling(node.left, result);
        findNodesWithoutSibling(node.right, result);
    }

    static void main() {
        NodesWithoutASibling sol = new NodesWithoutASibling();

        // Test Case 1: root = [37, 20, null, null, 113]
        // Tree:
        //       37
        //      /
        //     20
        //       \
        //        113
        // Nodes 20 and 113 have no siblings → expected: [20, 113]
        Integer[] arr1 = {37, 20, null, null, 113};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println("No siblings: " + sol.noSibling(root1)); // [20, 113]
    }
}
