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
    int result=0;
    public int pathSum(TreeNode root, int targetSum) {
        
        if(root==null) return 0;
        helper(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        
        return result;
    }
    
    public void helper(TreeNode root,int target,int current){
        if(root==null) return;
        current+=root.val;
        if(current==target) result++;
        helper(root.left,target,current);
        helper(root.right,target,current);
    }
}