
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

 class copyList {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node temp = dummy;
        Node fast;
        while (curr != null) {
            fast = curr.next.next;
            temp.next = curr.next;
            curr.next = fast;
            temp = temp.next;
            curr = fast;
        }
        return dummy.next;

    }
}