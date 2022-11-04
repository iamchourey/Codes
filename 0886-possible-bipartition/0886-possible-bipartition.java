class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int[] dis:dislikes){
            adj.get(dis[0]).add(dis[1]);
            adj.get(dis[1]).add(dis[0]);
        }
        int color[]=new int[n+1];
        
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                color[i]=1;
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                
                while(q.isEmpty()==false){
                    int curr=q.poll();
                    for(int neighbor:adj.get(curr)){
                        if(color[neighbor]==0){
                            color[neighbor]=-color[curr];
                            q.add(neighbor);
                        }
                        else if(color[neighbor]!=-color[curr]) return false;
                    }
                }
            }
        }
        return true;
    }
}