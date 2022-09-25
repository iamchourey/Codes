class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result=new ArrayList<>();
        
        if(n==1){
            result.add(0);
            return result;
        }
        int[] indegree=new int[n];
        List<List<Integer>> adj=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        
        for(int[] edge:edges){
            int u=edge[0],v=edge[1];
            indegree[u]++;
            indegree[v]++;
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i]==1) queue.add(i);
        }
        
        while(queue.isEmpty()==false){
            int size=queue.size();
            List<Integer> res=new ArrayList<>();
            while(size-->0){
                int node = queue.poll();
                res.add(node);
                for(int neighbor:adj.get(node)){
                    indegree[neighbor]--;
                    if(indegree[neighbor]==1) queue.add(neighbor);
                }
            }
            result=res;
        }
        return result;
    }
}