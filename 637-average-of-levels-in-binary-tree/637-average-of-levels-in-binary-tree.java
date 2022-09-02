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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(queue.isEmpty()==false){
            int size=queue.size();
            double sum=0,nodes=0;
            
            while(size-->0){
                TreeNode curr=queue.poll();
                sum+=(double)curr.val;
                nodes++;
                
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            result.add(sum/nodes);
        }
        return result;
    }
}