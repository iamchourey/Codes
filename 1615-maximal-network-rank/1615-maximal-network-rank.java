class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int []indegree=new int[n];
        int[][] isEdge=new int[n][n];
        
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            indegree[u]++;
            indegree[v]++;
            isEdge[u][v]=1;
            isEdge[v][u]=1;
        }
        int result=0;
        
        for(int u=0;u<n-1;u++){
            for(int v=u+1;v<n;v++){
                int rank=indegree[u]+indegree[v]-isEdge[u][v];
                result=Math.max(result,rank);
            }
        }
        return result;
    }
}