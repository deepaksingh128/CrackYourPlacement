class Solution {
    
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int sum = 0;

        if (root.val < low) {
            return rangeSumBST (root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST (root.left , low, high);
        } else {
            sum += root.val;
            sum += rangeSumBST (root.left, low, high);
            sum += rangeSumBST (root.right, low, high);
        }

        return sum;
    }
}
