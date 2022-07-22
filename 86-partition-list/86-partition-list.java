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
    public ListNode partition(ListNode head, int x) {
        
        ListNode firstPart=null,firstPartHead=null,secondPart=null,secondPartHead=null;
        ListNode curr=head;
        
        while(curr!=null){
            if(curr.val<x){
                if(firstPartHead==null){
                    firstPartHead=new ListNode(curr.val);
                    firstPart=firstPartHead;
                }
                else{
                    firstPart.next=new ListNode(curr.val);
                    firstPart=firstPart.next;
                }
            }
            else{
                if(secondPartHead==null){
                    secondPartHead=new ListNode(curr.val);
                    secondPart=secondPartHead;
                }
                else{
                    secondPart.next=new ListNode(curr.val);
                    secondPart=secondPart.next;
                }
            }
            curr=curr.next;
        }
        if(firstPart!=null) firstPart.next=secondPartHead;
        
        return (firstPartHead==null)?secondPartHead:firstPartHead;
    }
}