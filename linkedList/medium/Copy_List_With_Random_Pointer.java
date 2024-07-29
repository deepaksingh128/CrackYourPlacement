class Solution {
    // Method 2:- Without Using HashMap

    public Node copyRandomList(Node head) {
        Node curr = head;

        // Modify the original linked list , 
        // by adding same nodes inbetween
        while (curr != null) {
            Node forward = curr.next;
            Node node = new Node(curr.val);

            curr.next = node;
            node.next = forward;
            curr = forward;
        }

        // copy random pointers
        curr = head;
        while (curr != null) {
            Node random = curr.random;

            if (random != null) {
                curr.next.random = random.next;
            }

            curr = curr.next.next;
        }

        // extract deep copy
        Node dummy = new Node(-1);
        Node prev = dummy;
        curr = head;

        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }

        return dummy.next;
    }
}
