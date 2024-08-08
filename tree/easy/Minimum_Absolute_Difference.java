class Solution {
    private int minDiff;  
    private TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        inorder (root);
        return minDiff;
    }

    public void inorder (TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        if (prev != null) {
            minDiff = Math.min (minDiff, root.val - prev.val);
        }

        prev = root;

        inorder(root.right);
    }
}
