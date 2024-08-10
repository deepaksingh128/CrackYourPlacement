class Solution
{
    public static boolean isDeadEnd(Node root)
    {
        return deadEnd (root, 0, Integer.MAX_VALUE);
    }
    
    public static boolean deadEnd (Node root, int lo, int hi) {
        if (root == null) return false;
        
        if (root.left == null && root.right == null) {
            if (root.data - lo == 1 && hi - root.data == 1) {
                return true;
            }
        }
        
        return deadEnd(root.left, lo, root.data) || 
               deadEnd(root.right, root.data, hi);
    }
}
