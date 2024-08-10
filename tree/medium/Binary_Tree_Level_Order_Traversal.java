class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);

        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int n = queue.size();

            while(n > 0) {
                TreeNode node = queue.removeFirst();
                ans.add(node.val);

                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                n --;
            }
            res.add(ans);
        }

        return res;
    }
}
