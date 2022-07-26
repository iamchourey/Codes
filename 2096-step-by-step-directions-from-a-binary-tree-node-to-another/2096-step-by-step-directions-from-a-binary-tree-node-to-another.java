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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        StringBuilder lcaToStart=new StringBuilder();
        StringBuilder lcaToDest=new StringBuilder();
        
        TreeNode lca=getLca(root,startValue,destValue);
        dfs(lca,startValue,lcaToStart);
        dfs(lca,destValue,lcaToDest);
        
        StringBuilder result=new StringBuilder();
        
        for(int i=0;i<lcaToStart.length();i++) result.append("U");
        for(int i=0;i<lcaToDest.length();i++) result.append(lcaToDest.charAt(i));
        
        return result.toString();
    }
    
    public TreeNode getLca(TreeNode root,int left,int right){
        if(root==null || root.val==left || root.val==right) return root;
        TreeNode lca1=getLca(root.right,left,right);
        TreeNode lca2=getLca(root.left,left,right);
        if(lca1!=null && lca2!=null) return root;
        else return lca1==null?lca2:lca1;
    }
    
    public boolean dfs(TreeNode root,int value,StringBuilder sb){
        if(root==null) return false;
        if(root.val==value) return true;
        
        if(dfs(root.left,value,sb)) sb.insert(0,"L");
        else if(dfs(root.right,value,sb)) sb.insert(0,"R");
        
        return sb.length()>0;
    }
}