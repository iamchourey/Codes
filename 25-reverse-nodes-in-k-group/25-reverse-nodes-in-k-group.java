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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null) return null;
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        if(k>length) return head;
        ListNode prevFirst=head;
        ListNode curr=head,prev=null;
        int tempK=k;
        while(curr!=null && tempK>0){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            tempK--;
        }
        prevFirst.next=reverseKGroup(curr,k);
        return prev;
    }
}