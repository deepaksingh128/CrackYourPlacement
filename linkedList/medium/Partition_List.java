class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallDummyHead = new ListNode(0);
        ListNode small_itr = smallDummyHead;
        ListNode largeDummyHead = new ListNode(0);
        ListNode large_itr = largeDummyHead;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                small_itr.next = temp;
                small_itr = small_itr.next;
            } else {
                large_itr.next = temp;
                large_itr = large_itr.next;
            }

            temp = temp.next;
        }
        // connect
        small_itr.next = largeDummyHead.next;
        large_itr.next = null;

        return smallDummyHead.next;
    }
}
