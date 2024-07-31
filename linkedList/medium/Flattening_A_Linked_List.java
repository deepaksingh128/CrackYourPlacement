class Solution {
    // Function to flatten a linked list
    Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node headTwo = flatten(head.next);
        
        head = merge(head, headTwo);
        
        return head;
    }
    
    Node merge (Node list1, Node list2) {
        Node dummyNode = new Node(-1);
        Node ans = dummyNode;
        
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                ans.bottom = list1;
                ans = list1;
                list1 = list1.bottom;
            } else {
                ans.bottom = list2;
                ans = list2;
                list2 = list2.bottom;
            }
            ans.next = null;
        }
        
        if (list1 != null) ans.bottom = list1;
        else ans.bottom = list2;
        
        if (dummyNode.bottom != null) {
            dummyNode.bottom.next = null;
        }
        
        return dummyNode.bottom;
    }
}
