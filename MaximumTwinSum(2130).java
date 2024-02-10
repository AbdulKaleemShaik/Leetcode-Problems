// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Solution {
    public int pairSum(ListNode head) {
        ListNode nodeSlow = head, nodeFast = head;
        int res=0;

        while (nodeFast.next.next!=null){
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
        nodeSlow.next = reverseList(nodeSlow.next);
        nodeFast = head;
        while(nodeSlow.next!=null){
            res = Math.max(nodeFast.val+nodeSlow.next.val,res);
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next;
        }
        return res;
    }

  
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev; 

            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }
}