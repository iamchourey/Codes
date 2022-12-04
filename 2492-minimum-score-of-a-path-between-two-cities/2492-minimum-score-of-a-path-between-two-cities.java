class Solution {
    class Pair{
        int dest,dist;
        public Pair(int dest,int dist){
            this.dest=dest;
            this.dist=dist;
        }
    }
    public int minScore(int n, int[][] roads) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int road[]:roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }
        Queue<Integer> queue=new LinkedList<>();
        boolean visited[]=new boolean[n+1];
        queue.add(1);
        visited[1]=true;
        int result=Integer.MAX_VALUE;
        while(queue.isEmpty()==false){
            int curr=queue.poll();
            for(Pair p:adj.get(curr)){
                result=Math.min(result,p.dist);
                if(visited[p.dest]==false){
                    queue.add(p.dest);
                    visited[p.dest]=true;
                }
            }
        }
        return result;
    }
}