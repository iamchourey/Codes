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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null) return null;
        if(depth==1){
            TreeNode newRoot=new TreeNode(val);
            newRoot.left=root;
            return newRoot;
        }
        return helper(root,val,depth);
    }
    public TreeNode helper(TreeNode root,int val,int depth){
        if(root==null || depth<2) return root;
        if(depth==2){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(val);
            root.right=new TreeNode(val);
            root.left.left=left;
            root.right.right=right;
        }
        root.left=helper(root.left,val,depth-1);
        root.right=helper(root.right,val,depth-1);
        return root;
    }
}