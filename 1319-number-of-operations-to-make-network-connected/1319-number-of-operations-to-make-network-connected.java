class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int[] connection:connections){
            int u=connection[0];
            int v=connection[1];
            if(find(u,parent)!=find(v,parent)) union(u,v,parent,rank);
        }
        int result=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i) result++;
        }
        return result-1;
    }
    public int find(int val,int[] parent){
        if(parent[val]==val) return val;
        return parent[val]=find(parent[val],parent);
    }
    public void union(int u,int v,int[] parent,int[] rank){
        int leaderu=find(u,parent);
        int leaderv=find(v,parent);
        if(leaderu==leaderv) return;
        if(rank[leaderu]>rank[leaderv]) parent[leaderv]=leaderu;
        else if(rank[leaderv]>rank[leaderu]) parent[leaderu]=leaderv;
        else{
            parent[leaderv]=leaderu;
            rank[leaderu]++;
        }
        
    }
}