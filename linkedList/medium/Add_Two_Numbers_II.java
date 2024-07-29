class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse (l1);
        l2 = reverse (l2);

        ListNode l1Curr = l1;
        ListNode l2Curr = l2;
        int carry = 0;

        ListNode ansDummy = new ListNode(-1);
        ListNode ansCurr = ansDummy;

        while (l1Curr != null || l2Curr != null || carry != 0) {
            int sum = carry;

            if (l1Curr != null) {
                sum += l1Curr.val;
                l1Curr = l1Curr.next;
            }

            if (l2Curr != null) {
                sum += l2Curr.val;
                l2Curr = l2Curr.next;
            }

            int digit = sum % 10;
            carry = sum / 10;

            ansCurr.next = new ListNode(digit);
            ansCurr = ansCurr.next;
        }

        return reverse (ansDummy.next);
    }

    public ListNode reverse (ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = null;

        while (curr != null) {
            forward = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forward;
        }

        return prev;
    }
}
