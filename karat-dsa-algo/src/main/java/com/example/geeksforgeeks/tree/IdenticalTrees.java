package com.example.geeksforgeeks.tree;

import com.example.dsa.tree.BuildLevelOrderArray;

public class IdenticalTrees {

    public boolean isIdentical(Node r1, Node r2) {
        // If both are null, they are identical
        if (r1 == null && r2 == null) {
            return true;
        }

        // If one is null and the other is not, they are not identical
        if (r1 == null || r2 == null) {
            return false;
        }

        // Check current node values and recursively check left and right subtrees
        return (r1.data == r2.data)
                && isIdentical(r1.left, r2.left)
                && isIdentical(r1.right, r2.right);
    }

    static void main() {
        IdenticalTrees sol = new IdenticalTrees();
        Integer[] arr1 = {1, 2, 3, 4};
        Integer[] arr2 = {1, 2, 3, 4};

        Node n1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        Node n2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);

        System.out.println(sol.isIdentical(n1, n2));
    }
}
