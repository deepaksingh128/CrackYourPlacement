class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode pointToHead = new ListNode(0); // to point head 
                                                // (because , we might have to delete the head itself)
        pointToHead.next = head;

        ListNode prev = pointToHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return pointToHead.next;
    }
}
