//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }

        Long nextLong(){
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt();
            int Edge[] = new int[N];
            for(int i = 0; i < N; i++)
                Edge[i] = sc.nextInt();
            Solution ob = new Solution();
            long ans = ob.largesSumCycle(N, Edge);
            out.println(ans);            
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long largesSumCycle(int N, int Edge[]){
        long result[]=new long[1];
        result[0]=-1;
        boolean visited[]=new boolean[N];
        boolean path[]=new boolean[N];
        for(int i=0;i<N;i++){
            if(visited[i]==false){
                dfs(i,N,Edge,visited,path,result);
            }
        }
        return result[0];
    }
    public void dfs(int node,int n,int[] edge,boolean visited[],boolean path[],long[] result){
        visited[node]=true;
        path[node]=true;
        
        if(edge[node]!=-1){
            int adj=edge[node];
            if(visited[adj]==false){
                dfs(adj,n,edge,visited,path,result);
            }
            else if(path[adj]){
                int curr=adj;
                long res=0;
                do{
                    res+=curr;
                    curr=edge[curr];
                }while(curr!=adj);
                
                result[0]=Math.max(result[0],res);
            }
        }
        path[node]=false;
    }
}