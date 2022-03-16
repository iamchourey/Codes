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
    public int getDecimalValue(ListNode head) {
        
        int len=0;
        ListNode curr=head;
        
        while(curr!=null){
            len++;
            curr=curr.next;
        }
        
        --len;
        
        int ans=0;
        curr=head;
        
        while(curr!=null){
            ans+=Math.pow(2,len)*curr.val;
            len--;
            curr=curr.next;
        }
        
        return ans;
    }
}