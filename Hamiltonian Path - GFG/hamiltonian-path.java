//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int M = Integer.parseInt(input_line[1]);
            
            input_line = read.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> Edges = new ArrayList<ArrayList<Integer>>(); 
            for(int i = 0; i < M; i++){
                ArrayList<Integer> e = new ArrayList<Integer>();
                e.add(Integer.parseInt(input_line[2*i]));
                e.add(Integer.parseInt(input_line[2*i+1]));
                Edges.add(e);
            }
            Solution ob = new Solution();
            if(ob.check(N, M, Edges)){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=N;i++) adj.add(new ArrayList<>());
        for(ArrayList<Integer> edge:Edges){
            int u=edge.get(0);
            int v=edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[]=new boolean[N+1];
        for(int i=1;i<=N;i++){
            if(helper(N,adj,visited,i,0)) return true;
        }
        return false;
    }
    public static boolean helper(int n,ArrayList<ArrayList<Integer>> adj,boolean[] visited,int src,int count){
        visited[src]=true;
        count++;
        if(count==n) return true;
        for(int i=0;i<adj.get(src).size();i++){
            int neighbor=adj.get(src).get(i);
            if(!visited[neighbor]){
                if(helper(n,adj,visited,neighbor,count)) return true;
            }
        }
        visited[src]=false;
        return false;
    }
} 