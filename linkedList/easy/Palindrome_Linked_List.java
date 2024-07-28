class Solution {
    // Approach 3 :- Reversing the first half while traversing , no need to 
    //               write reverse function seperatly , then compare the two parts
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {     // if odd length
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.val != slow.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return prev == null && slow == null;
    }
}
