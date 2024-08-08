class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return isInvert(root.left, root.right);
    }

    public boolean isInvert (TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if ((root1.val == root2.val) 
            && isInvert(root1.left, root2.right)
            && isInvert(root1.right, root2.left)
        ) {
            return true;
        }

        return false;
    }
}
