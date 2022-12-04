class Solution {
    public int minScore(int n, int[][] roads) {
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        int distance[]=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        for(int i=0;i<=n;i++){
            rank[i]=1;
            parent[i]=i;
        }
        
        for(int road[]:roads){
            union(road[0],road[1],road[2],parent,rank,distance);
        }
        int par=find(1,parent);
        if(par==find(n,parent)) return distance[par];
        return -1;
    }
    public void union(int u,int v,int dist,int[] parent,int[] rank,int[] distance){
        int lu=find(u,parent);
        int lv=find(v,parent);
        
        int minDist=Math.min(distance[lu],distance[lv]);
        int minDistance=Math.min(minDist,dist);
        distance[lu]=distance[lv]=minDistance;
        
        if(lu==lv) return;
        if(rank[lv]<rank[lu]) parent[lv]=lu;
        else if(rank[lv]>rank[lu]) parent[lu]=lv;
        else{
            parent[lv]=lu;
            rank[lu]++;
        }
    }
    public int find(int val,int[] parent){
        if(parent[val]==val) return val;
        return parent[val]=find(parent[val],parent);
    } 
}