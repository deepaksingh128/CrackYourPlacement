class Solution {
    public Node subLinkedList(Node head1, Node head2) {
        // remove leading zeroes
        while (head1 != null && head1.data == 0) {
            head1 = head1.next; 
        }
        while (head2 != null && head2.data == 0) {
            head2 = head2.next;
        }
        
        // if both are null
        if (head1 == null && head2 == null) {
            Node head = new Node (0);
            return head;
        }
        
        // calculate lengths
        int len1 = length (head1);
        int len2 = length (head2);
        
        if (len2 > len1) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        if (len1 == len2) {
            Node t1 = head1;
            Node t2 = head2;
            
            while ( t1.data == t2.data ) {
                t1 = t1.next;
                t2 = t2.next;
                
                if (t1 == null) {  // that means both numbers are equal
                    return new Node (0);
                }
            }
            
            if (t2.data > t1.data) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        
        // reverse
        head1 = reverse (head1);
        head2 = reverse (head2);
        
        Node t1 = head1;
        Node t2 = head2;
        Node dummy = null;
        Node itr = dummy;
        
        
        while (t1 != null) {
            int t2Digit = 0;
            if (t2 != null) {
                t2Digit = t2.data;
            }
            
            if (t1.data < t2Digit) {
                t1.next.data = t1.next.data - 1;
                t1.data = t1.data + 10;
            }
            
            Node newNode = new Node (t1.data - t2Digit);
            
            if (dummy == null) {
                dummy = newNode;
                itr = newNode;
            } else {
                itr.next = newNode;
                itr = itr.next;
            }
            
            t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        
        dummy = reverse (dummy);
        
        while (dummy != null && dummy.data == 0) {
            dummy = dummy.next; 
        }
        
        return dummy;
    }
    
    // helper : to reverse
    public Node reverse (Node head) {
        if (head == null || head.next == null) return head;
        
        Node prev = null;
        Node curr = head;
        Node forward = null;
        
        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forward;
        }
        
        return prev;
    }
    
    // helper :- to calculate length 
    public int length (Node head) {
        int len = 0;
        Node temp = head;
        while (temp != null) {
            len ++;
            temp = temp.next;
        }
        
        return len;
    }
}
