/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        
        List<Integer> ls=new ArrayList<>();
        
        if(root==null)
            return ls;
        
        Stack<Node> st=new Stack<>();
        
        st.add(root);
        
        while(st.isEmpty()==false){
            
            Node curr=st.pop();
            ls.add(curr.val);
            
            for(int i=curr.children.size()-1;i>=0;i--){
                st.push(curr.children.get(i));
            }
        }
        
        return ls;
    }
}