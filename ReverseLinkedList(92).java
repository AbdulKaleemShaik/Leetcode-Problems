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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right)
            return head;

        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode prev = temp;
        for (int i = 0; i < left - 1; i++)
            prev = prev.next;

        ListNode present = prev.next;

        for (int i = 0; i < right - left; i++) {
            ListNode then = present.next;
            present.next = then.next;
            then.next = prev.next;
            prev.next = then;
        }
        return temp.next;
    }
}