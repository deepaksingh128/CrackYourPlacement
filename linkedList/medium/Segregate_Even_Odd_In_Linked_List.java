class Solution {
    Node divide(Node head) {
        if (head == null || head.next == null) return head;
        
        Node evenDummy = new Node(-1);
        Node evenItr = evenDummy;
        Node oddDummy = new Node(-1);
        Node oddItr = oddDummy;
        
        Node curr = head;
        
        while (curr != null) {
            if (curr.data % 2 == 0) {
                evenItr.next = curr;
                evenItr = evenItr.next;
            } else {
                oddItr.next = curr;
                oddItr = oddItr.next;
            }
            curr = curr.next;
        }
        evenItr.next = oddDummy.next;
        oddItr.next = null;
        
        return evenDummy.next;
    }
}
