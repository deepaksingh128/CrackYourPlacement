class Solution {
    // Using recursion :-
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return solveUsingRecursion (lists, 0);
    }

    public ListNode solveUsingRecursion (ListNode[] lists, int idx) {
        if (idx == lists.length - 1) {
            return lists[idx];
        } 

        ListNode head2 = solveUsingRecursion (lists, idx + 1);

        return mergeTwoSortedLists (lists[idx], head2);
    }

    public ListNode mergeTwoSortedLists (ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) return null;
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode temp1 = head1;
        ListNode temp2 = head2;

        ListNode dummyHead = new ListNode (-1);
        ListNode itr = dummyHead;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                itr.next = temp1;
                itr = temp1;
                temp1 = temp1.next;
            } else {
                itr.next = temp2;
                itr = temp2;
                temp2 = temp2.next;
            }
        }
        if (temp1 != null) itr.next = temp1;
        if (temp2 != null) itr.next = temp2;

        return dummyHead.next;
    }
}
