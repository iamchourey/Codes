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
    int level=-1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(root,0,res);
        
        return res;
    }
    
    public void helper(TreeNode root,int currLevel,List<Integer> res){
        if(root==null) return;
        
        if(currLevel>level){
            res.add(root.val);
            level=currLevel;
        }
        
        helper(root.right,currLevel+1,res);
        helper(root.left,currLevel+1,res);
    }
}