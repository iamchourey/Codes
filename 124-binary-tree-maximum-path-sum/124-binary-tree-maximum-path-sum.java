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
    public int maxPathSum(TreeNode root) {
        int maxPathSum[]=new int[1];
        maxPathSum[0]=Integer.MIN_VALUE;
        getMaxPathSum(root,maxPathSum);
        
        return maxPathSum[0];
    }
    
    public int getMaxPathSum(TreeNode root,int[] maxPathSum){
        if(root==null) return 0;
        
        int left=Math.max(0,getMaxPathSum(root.left,maxPathSum));
        int right=Math.max(0,getMaxPathSum(root.right,maxPathSum));
        
        maxPathSum[0]=Math.max(maxPathSum[0],root.val+left+right);
        return Math.max(left,right)+root.val;
    }
}