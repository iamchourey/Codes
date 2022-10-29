class Solution {
    public int makeConnected(int n, int[][] connections) {
        int cables=connections.length;
        if(cables<(n-1)) return -1;
        int networks=0;
        boolean seen[]=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] connection:connections){
            int u=connection[0];
            int v=connection[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(seen[i]==false){
                dfs(adj,n,seen,i);
                networks++;
            }
        }
        return networks-1;
    }
    public void dfs(List<List<Integer>> adj,int n,boolean[] seen,int src){
        if(seen[src]) return;
        seen[src]=true;
        for(int node:adj.get(src)){
            dfs(adj,n,seen,node);
        }
    }
}