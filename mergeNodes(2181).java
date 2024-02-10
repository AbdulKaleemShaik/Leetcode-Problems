class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode ptr = dummy;
        int s = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                ListNode res = new ListNode(s);
                ptr.next = res;
                ptr = ptr.next;
                s = 0;
            } else
                s += head.val;
            head = head.next;
        }
        return dummy.next;
    }
}