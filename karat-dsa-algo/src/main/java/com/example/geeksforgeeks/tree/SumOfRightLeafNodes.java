package com.example.geeksforgeeks.tree;

public class SumOfRightLeafNodes {

    int rightLeafSum(Node root) {
        if(root == null){
            return 0;
        }

        int sum = 0;

        // check if right branch exists and is a leaf
        if(root.right != null && root.right.left == null && root.right.right == null){
            sum = sum + root.right.data;
        }

        sum = sum + rightLeafSum(root.left);
        sum = sum + rightLeafSum(root.right);

        return sum;
    }

    static void main() {
        SumOfRightLeafNodes sol = new SumOfRightLeafNodes();

        Integer[] arr1 = {1, 2, 3, 4, 5, null, 8, null, 2, null, null, 6, 7};
        Node root1 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr1);
        System.out.println(sol.rightLeafSum(root1));

        Integer[] arr2 = {1, -2, 3, null, 5, null, 8};
        Node root2 = BuildTreeLevelOrderArray.buildTreeLevelOrder(arr2);
        System.out.println(sol.rightLeafSum(root2));
    }
}
