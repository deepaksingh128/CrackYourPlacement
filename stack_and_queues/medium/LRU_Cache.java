class LRUCache {

    // helper class
    class Node {
        int key, value;
        Node next, prev;
    }

    // helper data structures and variables
    Map<Integer, Node> cache; 
    int cap;
    Node head;  // dummy head
    Node tail;  // dummy tail

    // helper function to add node at first position
    private void addFirst (Node node) {
        Node nextNode = head.next;

        node.next = nextNode;
        node.prev = head;

        nextNode.prev = node;
        head.next = node;
    }

    // helper function to remove node
    private void removeNode (Node node) {
        Node leftNbr = node.prev;
        Node rightNbr = node.next;

        leftNbr.next = rightNbr;
        rightNbr.prev = leftNbr;

        node.next = null;
        node.prev = null;
    }

    // helper function to move to front
    private void moveToFront (Node node) {
        removeNode (node);
        addFirst (node);
    }

    // given constructor
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;

        head = new Node();
        tail = new Node();

        head.next = tail;
        tail.prev = head;
    }
    

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) {
            return -1;
        } else {
            int val = node.value;
            moveToFront(node);      // making it recently used
            return val;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            if (cache.size() == cap) {
                Node LRU_Node = tail.prev;
                cache.remove (LRU_Node.key);
                removeNode(LRU_Node);
            }
            cache.put(key, newNode);
            addFirst(newNode);
        } else {
            node.value = value;
            moveToFront (node);   // making it recently used
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
