class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode t = head;
        while (t != null) {
            if (t.next != null) {
                int g = gcd(t.val, t.next.val);
                ListNode new_node = new ListNode(g);
                ListNode n = t.next;
                t.next = new_node;
                new_node.next = n;
                t = n;
            } else {
                break;
            }
        }
        return head;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}

class ListNode {
    /**
     *
     */
    ListNode next;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}