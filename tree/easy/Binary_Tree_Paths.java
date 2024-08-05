class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();

        if (root == null) return res;
        if (root.left == null && root.right == null) {
            res.add(root.val + "");
            return res;
        }

        binaryTreePathsHelper (root, "");

        return res;
    }

    public void binaryTreePathsHelper (TreeNode root, String ans) {
        if (root == null) return;

        ans += root.val;

        if (root.left == null && root.right == null) {
            res.add (ans);
            return;
        }

        ans += "->";

        binaryTreePathsHelper (root.left, ans);
        binaryTreePathsHelper (root.right, ans);
    }
}
