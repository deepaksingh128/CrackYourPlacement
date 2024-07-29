class Solution
{
    Node compute(Node head)
    {
        if (head == null || head.next == null) return head;
        
        head = reverse(head);
        
        int maxTillNow = head.data;
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.next.data < maxTillNow) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxTillNow = current.data;
            }
        }
        
        head = reverse (head);
        
        return head;
    }
    
    Node reverse (Node head) {
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
}
