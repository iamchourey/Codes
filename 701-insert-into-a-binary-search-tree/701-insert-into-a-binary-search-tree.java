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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        TreeNode temp=new TreeNode(val);
        
        if(root==null)
            return temp;
        
        TreeNode parent=null,curr=root;
        
        while(curr!=null)
        {
            parent=curr;
            if(curr.val>val)
                curr=curr.left;
            else
                curr=curr.right;
        }
        if(val>parent.val)
            parent.right=temp;
        else
            parent.left=temp;
        
        return root;
    }
}