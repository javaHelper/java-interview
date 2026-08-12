package com.example.geeksforgeeks.tree;

public class RootToLeafPathSum {
    /**
     * Checks if there exists a root‑to‑leaf path whose sum equals target.
     *
     * @param root   the root of the binary tree
     * @param target the target sum
     * @return true if such a path exists, false otherwise
     */
    boolean hasPathSum(Node root, int target) {
        // Base case: empty tree → no path
        if (root == null) {
            return false;
        }

        // If leaf node, check if its value equals the remaining target
        if (root.left == null && root.right == null) {
            return root.data == target;
        }

        // Recurse on left and right subtrees with reduced target
        int remaining = target - root.data;
        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }


    // ==================== HELPER: BUILD TREE FROM LEVEL‑ORDER ARRAY ====================
    public static Node buildTreeFromArray(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        Node root = new Node(arr[0]);
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new Node(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new Node(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    static void main() {
        RootToLeafPathSum sol = new RootToLeafPathSum();

        // Example 1: [5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1]
        // Target = 22 → true (path 5→4→11→2)
        Integer[] arr1 = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1};
        Node root1 = buildTreeFromArray(arr1);
        System.out.println(sol.hasPathSum(root1, 22)); // true

        // Example 2: Same tree, target = 23 → false
        System.out.println(sol.hasPathSum(root1, 23)); // false

        // Example 3: [1, 2, 3], target = 3 → false (1→2 sum=3, but 2 is not leaf? Actually 2 is leaf, so 1+2=3, true? Wait: tree: 1 left=2 right=3, leaves are 2 and 3. Path 1→2 sum=3 → true)
        Integer[] arr2 = {1, 2, 3};
        Node root2 = buildTreeFromArray(arr2);
        System.out.println(sol.hasPathSum(root2, 3)); // true

        // Example 4: Empty tree → false
        Node root3 = buildTreeFromArray(new Integer[]{});
        System.out.println(sol.hasPathSum(root3, 0)); // false

        // Example 5: Single node [5], target=5 → true
        Node root4 = buildTreeFromArray(new Integer[]{5});
        System.out.println(sol.hasPathSum(root4, 5)); // true
    }
}
