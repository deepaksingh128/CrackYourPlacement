class Solution {
    public static void findPreSuc(Node root, Node[] pre, Node[] suc, int key) {
        // code here.
        // update pre[0] with the predecessor of the key
        // update suc[0] with the successor of the key
        
        
        // t.c. => O(H) , s.c.=> O(1)
        
        Node temp = root;
        
        while (temp != null) {
            if (temp.data <= key) {
                temp = temp.right;
            } else {
                suc[0] = temp;
                temp = temp.left;
            }
        }
        
        temp = root;
        while(temp != null) {
            if (temp.data >= key) {
                temp = temp.left;
            } else {
               pre[0] = temp;
               temp = temp.right;
            }
        }
    }
}
