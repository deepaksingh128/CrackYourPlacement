class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = invertTree (left);
        root.left = invertTree (right);

        return root;
    }
}
