class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        Boolean dp[]=new Boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!containsCycle(graph,i,new boolean[graph.length],dp)) result.add(i);
        }
        return result;
    }
    public boolean containsCycle(int[][] graph,int src,boolean[] visited,Boolean[] dp){
        if(dp[src]!=null) return dp[src];
        if(visited[src]==true) return true;
        visited[src]=true;
        for(int neigh:graph[src]){
            if(containsCycle(graph,neigh,visited,dp)) return dp[src]=true;
        }
        visited[src]=false;
        return dp[src]=false;
    }
}