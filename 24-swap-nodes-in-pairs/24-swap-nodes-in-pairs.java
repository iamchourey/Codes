/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        return helper(head,head.next);
    }
    public ListNode helper(ListNode first,ListNode second){
        if(first==null && second==null) return null;
        else if(second==null) return first;
        ListNode next=second.next;
        second.next=first;
        first.next=next==null?null:helper(next,next.next);
        return second;
    }
}