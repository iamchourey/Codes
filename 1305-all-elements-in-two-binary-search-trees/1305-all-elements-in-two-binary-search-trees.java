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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> ls=new ArrayList<>();
        
        helper(root1,ls);
        helper(root2,ls);
        
        Collections.sort(ls);
        
        return ls;
    }
    
    public void helper(TreeNode root,List<Integer> ls){
        
        if(root!=null){
            helper(root.left,ls);
            ls.add(root.val);
            helper(root.right,ls);
        }
    }
}