class Solution {
    private int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if (root.left == null && root.right == null) {
            return sum;
        } 

        solve (root);
        return sum;
    }

    public void solve (TreeNode root) {
        if (root == null) return;

        if (root.left != null && root.left.left == null && 
                    root.left.right == null) {
            sum += root.left.val;
        }

        solve (root.left);
        solve (root.right);
    }
}
