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
        
        List<Integer> res=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        helper(root1,pq);
        helper(root2,pq);
        
        while(pq.isEmpty()==false){
            res.add(pq.poll());
        }
        
        return res;
    }
    
    public void helper(TreeNode root,PriorityQueue<Integer> pq){
        
        if(root!=null){
            helper(root.left,pq);
            pq.offer(root.val);
            helper(root.right,pq);
        }
    }
}