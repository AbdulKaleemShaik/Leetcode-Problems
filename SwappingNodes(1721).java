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
    public ListNode swapNodes(ListNode head, int k) {
        // int count = 0;
        // ListNode temp = head;
        // while (temp.next != null) {
        // count++;
        // temp = temp.next;
        // }
        // temp = head;
        // for (int i = 1; i < k; i++) {
        // temp = temp.next;
        // }
        // ListNode dummy = temp;
        // int limit=count-k;
        // for (int i = k; i <= limit; i++) {
        // dummy = dummy.next;
        // }
        // int vall = temp.val;
        // temp.val = dummy.val;
        // dummy.val = vall;
        // return head;
    }

    ListNode left=head,rigth=head;
    for(int i = 1;i<k;i++)left=left.next;
    ListNode curr = left;while(curr.next!=null)
    {
        curr = curr.next;
        rigth = rigth.next;
    }
    int t = left.val;left.val=rigth.val;rigth.val=t;return head;
}