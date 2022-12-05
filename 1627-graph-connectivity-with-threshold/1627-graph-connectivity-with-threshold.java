class Solution {
    public void union(int u,int v,int[] parent,int[] rank){
        int lu=find(u,parent);
        int lv=find(v,parent);
        if(lu==lv) return;
        if(rank[lv]>rank[lu]) parent[lu]=lv;
        else if(rank[lu]>rank[lv]) parent[lv]=lu;
        else{
            parent[lv]=lu;
            rank[lu]++;
        }
    }
    public int find(int val,int parent[]){
        if(val==parent[val]) return val;
        return parent[val]=find(parent[val],parent);
    } 
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int q=queries.length;
        List<Boolean> res=new ArrayList<>();
        int[] parent=new int[n+1];
        int[] rank=new int[n+1];
        
        for(int i=0;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        for(int div=threshold+1;div<=n;div++){
            int divisor=div;
            int temp=div;
            while(divisor+temp<=n){
                union(divisor,divisor+temp,parent,rank);
                divisor+=temp;
            }
        }
        for(int[] query:queries){
            int u=query[0],v=query[1];
            if(find(u,parent)==find(v,parent)) res.add(true);
            else res.add(false);
        }
        return res;
    }
}