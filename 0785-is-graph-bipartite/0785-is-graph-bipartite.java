class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        
        for(int i=0;i<n;i++){
            if(color[i]==0){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                color[i]=1;
                
                while(q.isEmpty()==false){
                    int curr=q.poll();
                    for(int neighbor:graph[curr]){
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