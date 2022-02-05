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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        if(lists==null || lists.length==0)
            return null;
        
        for(int i=0;i<lists.length;i++){
            ListNode head=lists[i];
            
            while(head!=null){
                pq.add(head.val);
                head=head.next;
            }
        }
        
        ListNode resHead=null,curr=null;
        while(pq.isEmpty()==false){
            if(resHead==null){
                resHead=new ListNode(pq.poll());
                curr=resHead;
            }
            else{
                curr.next=new ListNode(pq.poll());
                curr=curr.next;
            }
        }
        
        return resHead;
    }
}