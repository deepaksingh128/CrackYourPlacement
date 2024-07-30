// Using recursion:-

class Solution {
    Node curr; // global variable
    
    void reorderlist(Node head) {
        curr = head;
        solveWithHelpOfRecursion (head);
    }
    
    public void solveWithHelpOfRecursion (Node head) {
        if (head == null) return;

        solveWithHelpOfRecursion(head.next);

        Node temp = curr.next;
        if (curr.next == null) {
            return;
        } else if (head == curr) {
            head.next = null;
            return;
        }

        curr.next = head;

        head.next = temp == head ? null : temp;
        curr = temp;
    }
}
