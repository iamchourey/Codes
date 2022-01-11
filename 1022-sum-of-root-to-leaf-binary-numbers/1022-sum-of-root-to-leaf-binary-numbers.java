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
    public int sumRootToLeaf(TreeNode root) {
        
        List<String> ls=new ArrayList<>();
        helper(root,"",ls);
        
        int sum=0;
        
        for(int i=0;i<ls.size();i++){
            String s=ls.get(i);
            int num=0;
            int base=1;
            for(int j=s.length()-1;j>=0;j--){
                num=num+(s.charAt(j)-'0')*base;
                base=base*2;
            }
            
            sum+=num;
        }
        return sum;
        
    }
    
    public void helper(TreeNode root,String str,List<String> ls){
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null)
        {
            str=str+root.val;
            ls.add(str);
        }
        
        str=str+root.val;
        helper(root.left,new String(str),ls);
        helper(root.right,new String(str),ls);
    }
}