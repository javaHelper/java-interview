#

Size of a Binary Tree

```java
static int getSize(Node root)
    {
        if (root == null)
            return 0;

        // Find the size of left and right
        // subtree.
        int left = getSize(root.left);
        int right = getSize(root.right);

        // return the size of curr subtree.
        return left + right + 1;
    }
```

```java
static int height(Node root) {
        if (root == null)
            return -1;

        // compute the height of left and right subtrees
        int lHeight = height(root.left);
        int rHeight = height(root.right);

        return Math.max(lHeight, rHeight) + 1;
    }
```