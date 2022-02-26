class Solution {
    public int shortestPathLength(int[][] graph) {
        
        int n=graph.length;
        
        if(n==1)
            return 0;
        
        int finalState=(1<<n)-1;
        
        Queue<int[]> q=new LinkedList<>();
        
        for(int i=0;i<n;i++){
            q.add(new int[]{i,(1<<i)});
        }
        
        int visited[][]=new int[n][finalState+1];
        int shortest=0;
        
        while(q.isEmpty()==false){
            
            int size=q.size();
            shortest++;
            
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
                int currNode=curr[0];
                int currState=curr[1];
                
                for(int neighbor:graph[currNode]){
                    int newState=currState | (1<<neighbor);
                    
                    if(newState==finalState)
                        return shortest;
                    
                    if(visited[neighbor][newState]==0){
                        visited[neighbor][newState]=1;
                        q.add(new int[]{neighbor,newState});
                    }
                }
            }
        }
        return -1;
    }
}