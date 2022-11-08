class Solution {
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges=new ArrayList<>();
        parent=new int[points.length];
        rank=new int[points.length];
        for(int i=0;i<points.length;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int dist=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,dist});
            }
        }
        int result=0;
        Collections.sort(edges,new Comparator<int[]>(){
           public int compare(int[] a1,int[] a2){
               return a1[2]-a2[2];
           } 
        });
        
        for(int[] edge:edges){
            if(find(edge[0])!=find(edge[1])){
                union(edge[0],edge[1]);
                result+=edge[2];
            }
        }
        return result;
    }
    public int find(int val){
        if(parent[val]==val) return val;
        return parent[val]=find(parent[val]);
    }
    public void union(int a,int b){
        int leaderOfA=find(a);
        int leaderOfB=find(b);
        if(leaderOfA==leaderOfB) return;
        if(rank[leaderOfA]>rank[leaderOfB]) parent[leaderOfB]=leaderOfA;
        else if(rank[leaderOfA]<rank[leaderOfB]) parent[leaderOfA]=leaderOfB;
        else{
            parent[leaderOfB]=leaderOfA;
            rank[leaderOfA]++;
        }
    }
}