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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        ListNode dummy = new ListNode(0);
        dummy.next = list1;
        ListNode prev = dummy;
        for (int i = 0; i < a; i++) {
            prev = prev.next;
        }
        ListNode after = prev;
        for (int i = a; i <= b + 1; i++) {
            after = after.next;
        }
        prev.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = after;
        return dummy.next;
    }
}
