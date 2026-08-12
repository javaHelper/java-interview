package com.example.geeksforgeeks.queue;

import com.example.geeksforgeeks.tree.BuildTreeLevelOrderArray;
import com.example.geeksforgeeks.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumNodeLevel {

    public int maxNodeLevel(Node root) {
        if (root == null) {
            return -1;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;
        int maxNodes = 0;
        int answer = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > maxNodes) {
                maxNodes = size;
                answer = level;
            }

            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            level++;
        }
        return answer;
    }

    static void main() {
        MaximumNodeLevel sol = new MaximumNodeLevel();
        Node root = BuildTreeLevelOrderArray.buildTreeLevelOrder(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(sol.maxNodeLevel(root));

        root = BuildTreeLevelOrderArray.buildTreeLevelOrder(new Integer[]{2, 1, 3, 4, 7, null, 8, null, null, 5});
        System.out.println(sol.maxNodeLevel(root));
    }
}
