class Solution {
    // Approach 1 :- Reverse the second half andd connect the nodes as required
    // Approach 2 :- Use stack instead of reversing 
    // Approach 3 :- Using recursion itself


    ListNode curr;
    public void reorderList(ListNode head) {
        curr = head;
        solveWithHelpOfRecursion (head);
    }

    public void solveWithHelpOfRecursion (ListNode head) {
        if (head == null) return;

        solveWithHelpOfRecursion(head.next);

        ListNode temp = curr.next;
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
