class Solution {
    // Method 1 :- BFS (level order traversal)
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            
            TreeNode node = null;
            while (n > 0) {
                node = queue.removeFirst();
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
                n --;
            }
            ans.add(node.val);
        }

        return ans;
    }
}
