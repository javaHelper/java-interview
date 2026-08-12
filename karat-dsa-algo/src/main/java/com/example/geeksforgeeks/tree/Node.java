package com.example.geeksforgeeks.tree;

public class Node {
    public int data;
    public Node left;
    public Node right;

    public Node(int val){
        this.data = val;
        this.left = this.right = null;
    }
}
