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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> ls=new ArrayList<>();
        inorder(root,ls);
        
        int start=0,end=ls.size()-1;
        while(start<end){
            if(ls.get(start)+ls.get(end)==k) return true;
            else if(ls.get(start)+ls.get(end)>k) end--;
            else start++;
        }
        return false;
    }
    public void inorder(TreeNode root,List<Integer> ls){
        if(root!=null){
            inorder(root.left,ls);
            ls.add(root.val);
            inorder(root.right,ls);
        }
    }
}