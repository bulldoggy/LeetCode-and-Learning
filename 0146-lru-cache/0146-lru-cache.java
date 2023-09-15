class LRUCache {
    HashMap<Integer, Node> cache;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node();
        right = new Node();
        left.next = right;
        left.prev = null;
        right.prev = left;
        right.next = null;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            remove(n);
            add(n);
            return n.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        add(cache.get(key));
        
        if(cache.size() > capacity) {
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
    private void remove(Node node) {
        Node l = node.prev;
        Node r = node.next;
        l.next = r;
        r.prev = l;
    }
    
    private void add(Node node) {
        Node p = this.right.prev;
        p.next = node;
        this.right.prev = node;
        node.prev = p;
        node.next = right;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    
    public Node() {}
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */