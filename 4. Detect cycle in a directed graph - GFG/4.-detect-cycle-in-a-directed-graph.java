// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[]=new boolean[V];
        boolean recurNodes[]=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(visited[i]==false){
                    if(dfs(adj,i,visited,recurNodes)) return true;
                }
        }
        return false;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean[] visited,boolean recurNodes[]){
        
        visited[src]=true;
        recurNodes[src]=true;
        
        ArrayList<Integer> neighbors=adj.get(src);
        for(int i=0;i<neighbors.size();i++){
            if(!visited[neighbors.get(i)] && dfs(adj,neighbors.get(i),visited,recurNodes))
            return true;
            else if(recurNodes[neighbors.get(i)]) return true;
        }
        recurNodes[src]=false;
        
        return false;
    }
}