/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Using dummy node avoid handling null pointer exception in a great extent
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyStart = new ListNode (-1);
        ListNode finalListTail = dummyStart; 
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                finalListTail.next = temp1;
                finalListTail = temp1;
                temp1 = temp1.next;
            } else {
                finalListTail.next = temp2;
                finalListTail = temp2;
                temp2 = temp2.next;
            }
        } 

        if (temp1 != null) {
            finalListTail.next = temp1;
        }

        if (temp2 != null) {
            finalListTail.next = temp2;
        }

        return dummyStart.next;
    }
}
