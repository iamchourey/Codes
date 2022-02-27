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
    
    public class Pair{
        TreeNode treeNode=null;
        int index=0;
        
        Pair(TreeNode t,int index){
            this.treeNode=t;
            this.index=index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root.left==null && root.right==null)
            return 1;
        
        LinkedList<Pair> q=new LinkedList<>();
        int ans=0;
        
        q.add(new Pair(root,0));
        
        while(q.isEmpty()==false){
            int size=q.size();
            int lm=q.getFirst().index;
            int rm=q.getFirst().index;
            while(size-- >0){
                Pair p=q.poll();
                int i=p.index;
                rm=p.index;
                
                if(p.treeNode.left!=null)
                    q.add(new Pair(p.treeNode.left,i*2+1));
                if(p.treeNode.right!=null)
                    q.add(new Pair(p.treeNode.right,i*2+2));
            }
            ans=Math.max(ans,rm-lm+1);
        }
        return ans;
    }
}