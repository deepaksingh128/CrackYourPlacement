class Tree
{
    // Method 1 :- Using extra space 
    private static List<Integer> nodes;
    
    public static float findMedian(Node root)
    {
        nodes = new ArrayList<>();
        inorder(root);
        
        int size = nodes.size();
        
        if (size % 2 == 1) {
            return nodes.get(size/2);
        } else {
            int mid1 = size / 2 - 1;
            int mid2 = size / 2;
            
            return (nodes.get(mid1) + nodes.get(mid2)) / 2.0f;
        }
    }
    
    public static void inorder(Node root) {
        if(root == null) return;
        inorder(root.left);
        nodes.add(root.data);
        inorder(root.right);
    }
}
