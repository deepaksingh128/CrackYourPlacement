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

// class Solution {
//     // Approach 4 :- Using recursion and Without changing the given List
//     //               Also , not using any extra space other than stack space


//     private ListNode curr;
//     public boolean isPalindrome(ListNode head) {
//         curr = head;
        
//         return recur(head);
//     }

//     public boolean recur (ListNode head) {

//         if (head == null) return true;

//         boolean ans = recur (head.next);
//         if (head.val != curr.val) {
//             return false;
//         }

//         curr = curr.next;

//         return ans;
//     }
// }
