import java.util.HashMap;
import java.util.Map;

class LRUCache {
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.val;
        }
        return -1;
    }

    public void remove(Node n) {
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void insert(Node n) {
        map.put(n.key, n);
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if (map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }
}

class Node {
    Node next, prev;
    int key, val;

    Node(int i, int j) {
        this.key = i;
        this.val = j;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */