/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> hm=new HashMap<>();
        Node curr=head,dummy=new Node(-1),prev=dummy;
        
        while(curr!=null){
            prev.next=new Node(curr.val);
            hm.put(curr,prev.next);
            curr=curr.next;
            prev=prev.next;
        }
        Node c1=head,c2=dummy.next;
        
        while(c1!=null){
            c2.random=hm.get(c1.random);
            c1=c1.next;
            c2=c2.next;
        }
        return dummy.next;
    }
}