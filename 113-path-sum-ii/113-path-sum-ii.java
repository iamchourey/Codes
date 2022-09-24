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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result=new ArrayList<>();
        getPaths(root,targetSum,result,new ArrayList<>());
        return result;
    }
    public void getPaths(TreeNode root,int target,List<List<Integer>> result,List<Integer> curr){
        if(root==null) return;
        if(root.left==null && root.right==null && root.val==target){
            curr.add(root.val);
            result.add(curr);
            return;
        }
        curr.add(root.val);
        getPaths(root.left,target-root.val,result,new ArrayList<>(curr));
        getPaths(root.right,target-root.val,result,new ArrayList<>(curr));
    }
}