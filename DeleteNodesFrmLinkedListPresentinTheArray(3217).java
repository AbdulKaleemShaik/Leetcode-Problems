import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while (head != null) {
            if (!set.contains(head.val)) {
                prev.next = head;
                prev = prev.next;
            }
            head = head.next;

        }
        prev.next = null;

        return dummy.next;

        // int max = 0;
        // for (int n : nums) {
        // if (n > max) {
        // max = n;
        // }
        // }
        // boolean[] seen = new boolean[max + 1];

        // for (int n : nums) {
        // seen[n] = true;
        // }
        // while (head != null && head.val <= max && seen[head.val]) {
        // head = head.next;
        // }
        // if (head == null) {
        // return head;
        // }
        // ListNode curr = head.next, prev = head;
        // while (curr != null) {
        // if (curr.val <= max && seen[curr.val]) {
        // prev.next = curr.next;
        // } else {
        // prev = curr;
        // }
        // curr = curr.next;
        // }
        // return head;

    }
}

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