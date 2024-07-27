class Solution {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode slow = new ListNode();
        slow = head;
        ListNode fast = new ListNode();
        fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } 

        return slow;
    }
}
