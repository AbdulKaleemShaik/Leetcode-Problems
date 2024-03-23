/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    if(!head || !head.next)return;
    let slow=head;
    let fast=head;
    while(fast && fast.next){
        slow=slow.next;
        fast=fast.next.next;
    }
    let rev=reverse(slow.next);
    slow.next=null;
    slow=head;
    while(slow && rev){
     let next1=slow.next;
     let next2=rev.next;
     slow.next=rev;
     rev.next=next1;
     slow=next1;
     rev=next2;
    }
    
};

function reverse(head){
    let prev=null;
    while(head){
        let nex=head.next;
        head.next=prev;
        prev=head;
        head=nex;
    }
    return prev;
};