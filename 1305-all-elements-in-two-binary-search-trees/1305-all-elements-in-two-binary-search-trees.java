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
    
    public void Merge(List<Integer> ls1,List<Integer> ls2,List<Integer> res){
        
        int i=0,j=0;
        while(i<ls1.size() && j<ls2.size()){
            if(ls1.get(i)<ls2.get(j)){
                res.add(ls1.get(i));
                i++;
            }else{
                res.add(ls2.get(j));
                j++;
            }
        }
        
        while(i<ls1.size()){
            res.add(ls1.get(i));
            i++;
        }
        
        while(j<ls2.size()){
            res.add(ls2.get(j));
            j++;
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        
        helper(root1,ls1);
        helper(root2,ls2);
        
        Merge(ls1,ls2,res);
        
        return res;
    }
    
    public void helper(TreeNode root,List<Integer> ls){
        
        if(root!=null){
            helper(root.left,ls);
            ls.add(root.val);
            helper(root.right,ls);
        }
    }
}