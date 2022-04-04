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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first=head,last=head,temp=head;
        
        for(int i=1;i<k;i++)
        {
            first=first.next;
            temp=temp.next;
        }
        while(temp.next!=null)
        {
            last=last.next;
            temp=temp.next;
        }
        
        int tem=first.val;
        first.val=last.val;
        last.val=tem;
        
        return head;
    }
}