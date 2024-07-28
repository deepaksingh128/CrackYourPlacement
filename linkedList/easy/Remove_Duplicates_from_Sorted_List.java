class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tempOne = head;
        ListNode tempTwo = head.next;

        while (tempTwo != null) {
            if (tempOne.val == tempTwo.val) {
                tempTwo = tempTwo.next;
                tempOne.next = tempTwo;
            } else {
                tempOne = tempOne.next;
                tempTwo = tempTwo.next;
            }
        }
        
        return head;
    }
}
