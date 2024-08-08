class Solution {
    // Using StringBuilder
    
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<String>();
        solve (root, new StringBuilder());
        return res;
    }

    public void solve (TreeNode root, StringBuilder ans) {
        if (root == null) {
            return;
        }

        int len = ans.length();
        ans.append(root.val);

        if (root.left == null && root.right == null) {
            res.add(ans.toString());
        } else {
            ans.append("->");
            solve (root.left, ans);
            solve (root.right, ans);
        }

        ans.setLength(len);
    }
}
