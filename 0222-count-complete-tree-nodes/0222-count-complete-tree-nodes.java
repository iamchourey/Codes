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
    public int countNodes(TreeNode root) {
        int leftHeight=0,rightHeight=0;
        TreeNode curr=root;
        
        while(curr!=null){
            leftHeight++;
            curr=curr.left;
        }
        curr=root;
        while(curr!=null){
            rightHeight++;
            curr=curr.right;
        }
        if(leftHeight==rightHeight) return (int)Math.pow(2,leftHeight)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}