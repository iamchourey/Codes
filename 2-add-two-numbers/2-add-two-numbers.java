
 /* Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  } 
  */
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode res=null,resHead=null;
        boolean firstPass=true;
        
        int carry=0,sum=0;
        
        while(l1!=null || l2!=null)
        {
            if(l1==null)
                sum=carry+l2.val;
            else if(l2==null)
                sum=carry+l1.val;
            else
                sum=carry+l1.val+l2.val;

            int digit=sum%10;
            carry=sum/10;
            
            ListNode temp=new ListNode(digit);
            
            if(firstPass)
            {
                res=temp;
                resHead=temp;
                firstPass=false;
            }else
            {
                res.next=temp;
                res=res.next;
            }
            
            if(l1==null)
                l2=l2.next;
            else if(l2==null)
                l1=l1.next;
            else
            {
                l1=l1.next;
                l2=l2.next;
            }
        }
        
        if(carry!=0)
        {
            ListNode car=new ListNode(carry);
            res.next=car;
        }
        
        
        return resHead;
        
}
}