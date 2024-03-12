import java.util.HashMap;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        dummy.next = head;
        ListNode temp = dummy;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);
        while (temp != null) {
            sum += temp.val;
            map.put(sum, temp);
            temp = temp.next;
        }
        temp = dummy;
        sum = 0;
        while (temp != null) {
            sum += temp.val;
            if (map.containsKey(sum)) {
                ListNode ans = map.get(sum);
                temp.next = ans.next;
            }
            temp = temp.next;

        }
        return dummy.next;
    }
}