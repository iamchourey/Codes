//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        //Please code here
        int result[]=new int[1];
        result[0]=Integer.MIN_VALUE;
        helper(root,false,0,0,target,result);
        return result[0]==Integer.MIN_VALUE?-1:result[0];
    }
    public static void helper(Node root,boolean found,int sum1,int sum2,int target,int result[]){
        if(root==null) return;
        if(root.data==target) found=true;
        if(found && root.left==null && root.right==null){
            result[0]=Math.max(result[0],sum1-(sum2+(root.data==target?0:root.data)));
            return;
        }
        if(found){
            helper(root.left,found,sum1,sum2+(root.data==target?0:root.data),target,result);
            helper(root.right,found,sum1,sum2+(root.data==target?0:root.data),target,result);
        }
        else{
            helper(root.left,found,sum1+root.data,sum2,target,result);
            helper(root.right,found,sum1+root.data,sum2,target,result);
        }
        
    }
}