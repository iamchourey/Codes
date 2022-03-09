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
    public ListNode deleteDuplicates(ListNode head) {
        
//         if(head==null || head.next==null)
//             return head;
        
//         while(head!=null && head.next!=null && head.val==head.next.val)
//         {
//             int val=head.val;
//             while(head!=null && head.val==val)
//                 head=head.next;
//         }
        
//         if(head==null || head.next==null)
//             return head;
        
//         ListNode curr=head;
        
//         while(curr.next!=null && curr.next.next!=null)
//         {
//             if(curr.next.val!=curr.next.next.val)
//                 curr=curr.next;
//             else
//             {
//                 int val=curr.next.val;
//                 ListNode next=curr.next;
//                 while(next!=null && next.val==val)
//                     next=next.next;
                
//                 curr.next=next;
//             }
//         }
//         return head;
        
        //SOLUTION 2
        
        for(ListNode curr=head;curr!=null && curr.next!=null;)
        {
            ListNode q,p=curr.next;
            int count=0;
            
            for(q=p;q!=null && p.val==q.val;q=q.next)
                count++;
            
            if(head.val==p.val)
                curr=head=q;
            else if(count>1)
                curr.next=q;
            else
                curr=curr.next;
        }
        
        return head;
    }
}