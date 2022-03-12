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
        Node curr=head;
        while(curr!=null){
            Node forw=curr.next;
            Node node=new Node(curr.val);
            curr.next=node;
            node.next=forw;
            curr=forw;
        }
        curr=head;
        while(curr!=null){
            Node random=curr.random;
            if(random!=null) curr.next.random=random.next;
            curr=curr.next.next;
        }
        Node dummy=new Node(-1),prev=dummy;
        curr=head;
        while(curr!=null){
            prev.next=curr.next;
            curr.next=curr.next.next;
            curr=curr.next;
            prev=prev.next;
        }
        return dummy.next;
    }
}