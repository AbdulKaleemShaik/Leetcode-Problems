
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode l1 = reverseList(head);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int c = 0;
        while (l1 != null || c == 1) {
            int s = 0;
            if (l1 != null) {
                s += l1.val;
                l1 = l1.next;
            }

            s *= 2;
            s += c;
            c = s / 10;
            int res = s % 10;
            ListNode node = new ListNode(res);
            dummy.next = node;
            dummy = dummy.next;
        }
        return reverseList(curr.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode nw = head;
        ListNode temp = null;
        while (nw != null) {
            ListNode n = nw.next;
            nw.next = temp;
            temp = nw;
            nw = n;

        }
        return temp;

    }
}