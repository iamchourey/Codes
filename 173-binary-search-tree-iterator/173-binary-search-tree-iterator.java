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
class BSTIterator {
    
    List<Integer> ls;
    int pointer;

    public BSTIterator(TreeNode root) {
        ls=new ArrayList<>();
        ls.add(-1);
        pointer=0;
        
        inorder(root,ls);
        
    }
    
    public void inorder(TreeNode root,List<Integer> ls){
        if(root!=null){
            inorder(root.left,ls);
            ls.add(root.val);
            inorder(root.right,ls);
        }
    }
    
    public int next() {
        pointer++;
        return ls.get(pointer);
    }
    
    public boolean hasNext() {
        return !(pointer==ls.size()-1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */