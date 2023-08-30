class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (n == count) {
            head = head.next;
            return head;
        }
        int i = 1;
        ListNode tem = head;
        while (i < (count - n)) {
            tem = tem.next;
            i++;
        }
        tem.next = tem.next.next;
        return head;
    }
}