class Solution {
    // to reverse k length list
    ListNode tempHead = null;
    ListNode tempTail = null;

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = length (head);
        ListNode ansHead = null;
        ListNode ansTail = null;
        ListNode curr = head;

        while (len >= k) {
            int tempK = k;
            while (tempK-- > 0) {
                ListNode forward = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = forward;
            }
            if (ansHead == null) {
                ansHead = tempHead;
                ansTail = tempTail;
            } else {
                ansTail.next = tempHead;
                ansTail = tempTail;
            }

            tempHead = null;
            tempTail = null;
            len -= k;
        }

        ansTail.next = curr;

        return ansHead;
    }

    // helper function to calculate length
    public int length (ListNode head) {
        ListNode curr = head;
        int len = 0;

        while (curr != null) {
            curr = curr.next;
            len ++;
        }

        return len;
    }

    // helper function to reverse list of length k
    public void addFirst (ListNode node) {
        if (tempHead == null) {
            tempHead = node;
            tempTail = node;
        } else {
            node.next = tempHead;
            tempHead = node;
        }
    }
}
