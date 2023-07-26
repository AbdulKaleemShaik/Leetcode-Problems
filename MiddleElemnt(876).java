class Solution {
    public ListNode middleNode(ListNode head) {
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            ++count;
            temp=temp.next;
        }
        temp=head;
        int middle=count/2;
        while(middle-->0){
            temp=temp.next;

        }
        return temp;
    }
}
class ListNode{

    public ListNode next;
    
}
