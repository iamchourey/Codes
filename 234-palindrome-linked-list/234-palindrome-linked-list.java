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
    public boolean isPalindrome(ListNode head) {
        
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        ListNode reverse=reverseList(slow);
        ListNode curr=head;
        
        while(reverse!=null){
            if(curr.val!=reverse.val) return false;
            reverse=reverse.next;
            curr=curr.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head){
        ListNode curr=head,prev=null;
        
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
}