class Solution {
    
    private List<List<Integer>> createGraph(int n,int edges[][]){
        List<List<Integer>> graph = new ArrayList();
        for(int i=0;i<n;i++) graph.add(new ArrayList());
        
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            
            graph.get(u).add(v);
        }
        
        return graph;
    }
    
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> redGraph = createGraph(n,redEdges);
        List<List<Integer>> blueGraph = createGraph(n,blueEdges);
        
        int startRed[]=new int[n];
        Arrays.fill(startRed,Integer.MAX_VALUE);
        startRed[0]=0;
        
        int startBlue[]=new int[n];
        Arrays.fill(startBlue,Integer.MAX_VALUE);
        startBlue[0]=0;
        
        //do some coding here....
        ArrayDeque<int[]> q= new ArrayDeque();
        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        
        while(q.isEmpty()==false){
            int curr[]=q.pollFirst();
            int src=curr[0],color=curr[1];
            if(color==0){
                for(Integer nbr:blueGraph.get(src)){
                    if(startBlue[nbr]>startRed[src]+1){
                        q.add(new int[]{nbr,1});
                        startBlue[nbr]=startRed[src]+1;
                    }
                }
            }else{
                for(Integer nbr:redGraph.get(src)){
                    if(startRed[nbr]>startBlue[src]+1){
                        q.add(new int[]{nbr,0});
                        startRed[nbr]=startBlue[src]+1;
                    }
                }
            }
        }
        
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Math.min(startRed[i],startBlue[i]);
            if(ans[i]==Integer.MAX_VALUE) ans[i]=-1;
        }
        return ans;
    }
}