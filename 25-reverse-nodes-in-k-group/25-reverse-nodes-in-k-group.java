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
        
        ListNode curr=head,prevFirst=null;
        boolean firstPass=true;
        
        int len=0;
        for(ListNode i=head;i!=null;i=i.next)
            len++;
        
        if(len<k)
            return head;
        
        while(curr!=null)
        {
            if(len<k)
            {
                prevFirst.next=curr;
                break;
            }
            ListNode first=curr,prev=null;
            int count=0;
            
            while(curr!=null && count<k)
            {
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
                count++;
            }
            if(firstPass)
            {
                head=prev;
                firstPass=false;
            }else{
                prevFirst.next=prev;
            }
            prevFirst=first;
            len=len-k;
        }
        
        return head;
        
    }
}