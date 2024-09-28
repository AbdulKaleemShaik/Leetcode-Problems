import java.util.ArrayList;
import java.util.List;

class MyCircularDeque {
    int size;
    List<Integer> li;

    public MyCircularDeque(int k) {
        this.size = k;
        li = new ArrayList<>(k);
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            li.add(0, value);
            return true;
        }

        return false;

    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            li.add(value);
            return true;
        }

        return false;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;
        li.remove(0);
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;
        li.remove(li.size() - 1);
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return li.get(0);

    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return li.get(li.size() - 1);

    }

    public boolean isEmpty() {
        return li.size() == 0;
    }

    public boolean isFull() {
        return li.size() == size;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

class MyCircularDequee {
    Node head = new Node(-1);
    Node tail = new Node(-1);
    int size;
    int currSize;

    public MyCircularDequee(int k) {
        head.next = tail;
        tail.prev = head;
        size = k;
        currSize = 0;
    }

    public boolean insertFront(int value) {
        if (currSize == size)
            return false;
        addNode(head, value);
        currSize++;
        return true;
    }

    public boolean insertLast(int value) {
        if (currSize == size)
            return false;
        addNode(tail.prev, value);
        currSize++;
        return true;
    }

    public boolean deleteFront() {
        if (currSize == 0)
            return false;
        deleteNode(head.next);
        currSize--;
        return true;
    }

    public boolean deleteLast() {
        if (currSize == 0)
            return false;
        deleteNode(tail.prev);
        currSize--;
        return true;
    }

    public int getFront() {
        if (currSize == 0)
            return -1;
        return head.next.val;
    }

    public int getRear() {
        if (currSize == 0)
            return -1;
        return tail.prev.val;
    }

    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == size;
    }

    public void addNode(Node head, int value) {
        Node after = head.next;
        Node temp = new Node(value);
        head.next = temp;
        temp.prev = head;
        temp.next = after;
        after.prev = temp;
    }

    public void deleteNode(Node head) {
        Node after = head.next;
        Node before = head.prev;
        before.next = after;
        after.prev = before;
    }

}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */