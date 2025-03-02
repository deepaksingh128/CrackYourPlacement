class Solution {
    // Approach 2 :- Bottom-up
    // t.c.=> O(n)

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public int height (TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = height(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return 1 + Math.max (leftHeight, rightHeight);
    }
}
