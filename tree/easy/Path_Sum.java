class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return solve (root, targetSum);
    }

    public boolean solve (TreeNode root, int target) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return true;
            }
        }

        if (solve (root.left, target - root.val)) {
            return true;
        }
        if (solve (root.right, target - root.val)) {
            return true;
        }
        
        return false;
    }

}
