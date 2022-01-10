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
    public int minDiffInBST(TreeNode root) {
        List<Integer> ls=new ArrayList<>();
        inOrder(root,ls);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<ls.size();i++){
            min=Math.min(min,ls.get(i)-ls.get(i-1));
        }
        
        return min;
    }
    public void inOrder(TreeNode root,List<Integer> ls){
        
        if(root!=null){
            inOrder(root.left,ls);
            ls.add(root.val);
            inOrder(root.right,ls);
        }
    }
}