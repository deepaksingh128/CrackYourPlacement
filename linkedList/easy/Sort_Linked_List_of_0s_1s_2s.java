

//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{ 
    // Check for all 0s , all 1s and all 2s
    // all 2s has to be handeled carefully
    static Node segregate(Node head)
    {
        if(head == null || head.next == null){
            return head;
        }
        // Using dummy nodes
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node dummy2 = new Node(-1);
        Node tail0 = dummy0;
        Node tail1 = dummy1;
        Node tail2 = dummy2;
        
        Node curr = head;
        while(curr != null){
            if(curr.data == 0){
                tail0.next = curr;
                tail0 = tail0.next;
            }else if(curr.data == 1){
                tail1.next = curr;
                tail1 = tail1.next;
            }else{
                tail2.next = curr;
                tail2 = tail2.next;
            }
            curr = curr.next;
        }
        tail0.next = dummy1.next != null ? dummy1.next : dummy2.next;     // when all 2: 2 2 2 2 2
        tail1.next = dummy2.next;
        if(tail2 != null) tail2.next = null;   // NOTE this also , otherwise loop might possible
        
        return dummy0.next;
    }
}
