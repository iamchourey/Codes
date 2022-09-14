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
    public int pseudoPalindromicPaths (TreeNode root) {
        
        if(root==null || (root.left==null && root.right==null)) return 1;
        Set<Integer> set=new HashSet<>();
        int result[]=new int[1];
        
        getPalindromePaths(root,set,result);
        
        return result[0];
    }
    
    public void getPalindromePaths(TreeNode root,Set<Integer> set,int[] result){
        if(set.contains(root.val)){
            set.remove(root.val);
        }else{
            set.add(root.val);
        }
        
        if(root.left==null && root.right==null){
            if(set.size()==0 || set.size()==1) result[0]++;
            return;
        }
        
        if(root.left!=null) getPalindromePaths(root.left,new HashSet(set),result);
        if(root.right!=null) getPalindromePaths(root.right,new HashSet(set),result);
    }
}