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
    int min=Integer.MAX_VALUE;
    Integer pre=null;
    public int minDiffInBST(TreeNode root) {

        inOrder(root);
        
        return min;
    }
    public void inOrder(TreeNode root){
        
        if(root!=null){
            inOrder(root.left);
            if(pre!=null)
                min=Math.min(min,root.val-pre);
            pre=root.val;
            inOrder(root.right);
        }
    }
}