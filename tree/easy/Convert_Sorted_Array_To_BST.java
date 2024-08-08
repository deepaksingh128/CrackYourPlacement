class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return solve (nums, 0, n - 1);
    }

    public TreeNode solve (int[] nums, int si, int ei) {
        if (si > ei) return null;

        int mid = si + (ei -si) / 2; 
        TreeNode node = new TreeNode (nums[mid]);

        node.left = solve (nums, si, mid - 1);
        node.right = solve (nums, mid + 1, ei);

        return node;
    }
}
