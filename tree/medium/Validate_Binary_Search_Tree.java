class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper (root, null, null);
    }

    public boolean helper (TreeNode root, Integer lo, Integer hi) {
        if (root == null) return true;

        int val = root.val;

        if (lo != null && val <= lo) return false;
        if (hi != null && val >= hi) return false;

        if (!helper(root.left, lo, val)) return false;
        if (!helper(root.right, val, hi)) return false;

        return true;
    }
}
