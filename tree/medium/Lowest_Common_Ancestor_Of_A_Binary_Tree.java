class Solution {
    // Without using extra space 
    
    private TreeNode LCA = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LCA = null;
        lca (root, p, q);
        return LCA;
    }

    public boolean lca (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean self = (root.val == p.val || root.val == q.val);

        boolean left = lca (root.left, p, q);
        boolean right = lca (root.right, p, q);

        if (left && right || self && left || self && right) {
            LCA = root;
            return true;
        }

        return self || left || right;
    }
}
