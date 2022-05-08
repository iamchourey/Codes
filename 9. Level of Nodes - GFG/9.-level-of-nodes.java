// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int X = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.levelOfX(V,adj,X));
        }
    }
}
// } Driver Code Ends


class Solution
{
    class Node{
        int val,level;
        
        public Node(int v,int lvl){
            this.val=v;
            this.level=lvl;
        }
    }
    public int levelOfX(int V, ArrayList<ArrayList<Integer>> adj, int X) 
    {
        // Code here
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(0,0));
        boolean visited[]=new boolean[V];
        visited[0]=true;
        
        while(q.isEmpty()==false){
            Node node=q.poll();
            if(node.val==X) return node.level;
            
            for(int i=0;i<adj.get(node.val).size();i++){
                int neighbor=adj.get(node.val).get(i);
                if(!visited[neighbor]){
                    q.add(new Node(neighbor,node.level+1));
                    visited[neighbor]=true;
                }
            }
        }
        return -1;
    }
}