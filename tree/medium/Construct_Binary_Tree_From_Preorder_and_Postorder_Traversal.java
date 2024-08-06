class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        return constructFromPrePostHelper(preorder, 0, n-1, postorder, 0, n-1);
    }

    public TreeNode constructFromPrePostHelper(int[] preorder, int psi, int pei, 
                                              int[] postorder, int ppsi, int ppei) {
        if (psi > pei) {
            return null;
        }

        TreeNode root = new TreeNode (preorder[psi]);
        if (psi == pei) return root;

        int idx = ppsi;
        while (postorder[idx] != preorder[psi+1]) {
            idx ++;
        }

        int tnel = idx - ppsi + 1;

        root.left = constructFromPrePostHelper(preorder, psi+1, psi + tnel, postorder, 
                                                ppsi, idx);
        root.right = constructFromPrePostHelper(preorder, psi + tnel + 1, pei, postorder, 
                                                idx + 1, ppei - 1);

        return root;
    }
}
