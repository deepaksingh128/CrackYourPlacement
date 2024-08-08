class Solution {

    public int diameterOfBinaryTreeHelper (TreeNode root, int[] ans) {
        if (root == null) return 0;

        int left = diameterOfBinaryTreeHelper (root.left, ans);
        int right = diameterOfBinaryTreeHelper (root.right, ans);

        ans[0] = Math.max (ans[0], left + right);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];  // refernce type, so that ans persist
                                // or use global variable instead
        ans[0] = Integer.MIN_VALUE;

        diameterOfBinaryTreeHelper (root, ans);
        return ans[0];
    }
}
