/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        Stack<TreeNode> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        int maxDepth=1;
        st1.push(root);
        st2.push(1);
        
        while(st1.isEmpty()==false){
            TreeNode curr=st1.pop();
            int depth=st2.pop();
            
            maxDepth=Math.max(maxDepth,depth);
            
            if(curr.left!=null){
                st1.push(curr.left);
                st2.push(depth+1);
            }
            if(curr.right!=null){
                st1.push(curr.right);
                st2.push(depth+1);
            }
        }
        
        return maxDepth;
    }
}