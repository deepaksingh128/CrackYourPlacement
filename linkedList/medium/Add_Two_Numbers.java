class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        ListNode ansDummy = new ListNode(-1);
        ListNode ansCurr = ansDummy;
        int carry = 0;

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

        return ansDummy.next;
    }

}
