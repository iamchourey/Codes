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
    int preIndex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTree(preorder,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode constructTree(int[] preorder,int[] inorder,int istart,int iend,Map<Integer,Integer> map){
        if(istart>iend) return null;
        int iIndex=map.get(preorder[preIndex]);
        TreeNode root=new TreeNode(preorder[preIndex++]);
        root.left=constructTree(preorder,inorder,istart,iIndex-1,map);
        root.right=constructTree(preorder,inorder,iIndex+1,iend,map);
        return root;
    }
}