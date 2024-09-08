class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        int base = n / k;
        int extra = n % k;
        ListNode[] res = new ListNode[k];
        temp = head;
        for (int i = 0; i < k; i++) {
            ListNode curr_head = temp;
            int size = base + (extra > 0 ? 1 : 0);
            extra--;
            for (int j = 0; j < size - 1 && temp != null; j++) {
                temp = temp.next;
            }
            if (temp != null) {
                ListNode next_node = temp.next;
                temp.next = null;
                temp = next_node;
            }
            res[i] = curr_head;
        }
        return res;
    }
}