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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first=head,second=head;
        for(int i=0;i<n;i++) second=second.next;
        if(second==null) return head.next;
        while(second!=null && second.next!=null){
            first=first.next;
            second=second.next;
        }
        first.next=first.next.next;
        return head;
    }
}