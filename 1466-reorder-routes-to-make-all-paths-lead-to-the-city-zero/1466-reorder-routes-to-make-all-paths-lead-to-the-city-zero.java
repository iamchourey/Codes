class Solution {
    class Pair{
        int neighbor;
        String dir;
        public Pair(int n,String dir){
            this.neighbor=n;
            this.dir=dir;
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<Pair>());
        boolean visited[]=new boolean[n];
        int result=0;
        for(int[] connection:connections){
            int u=connection[0];
            int v=connection[1];
            String dir=Character.toString((char)('0'+u))+"to"+Character.toString((char)('0'+v));
            adj.get(u).add(new Pair(v,dir));
            adj.get(v).add(new Pair(u,dir));
        }
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(0,""));
        visited[0]=true;
        while(queue.isEmpty()==false){
            Pair curr=queue.poll();
            int u=curr.neighbor;
            for(Pair p:adj.get(u)){
                int neigh=p.neighbor;
                if(visited[neigh]==false) {
                    String dir=Character.toString((char)('0'+neigh))+"to"+Character.toString((char)('0'+u));
                if(dir.equals(p.dir)==false) result++;
                    queue.add(new Pair(neigh,""));
                    visited[neigh]=true;
                }
            }
        }
        return result;
    }
}