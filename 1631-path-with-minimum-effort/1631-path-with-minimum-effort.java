class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m=heights.length,n=heights[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
        int[][] dist=new int[m][n];
        
        for(int i=0;i<m;i++) Arrays.fill(dist[i],Integer.MAX_VALUE);
        
        pq.offer(new int[]{0,0,0});
        
        while(pq.isEmpty()==false){
            int[] temp=pq.poll();
            int d=temp[0];
            int x=temp[1];
            int y=temp[2];
            
            if(x==m-1 && y==n-1) return d;
            
            for(int dir[]:dirs){
                int x1=x+dir[0];
                int y1=y+dir[1];
                if(x1>=0 && y1>=0 && x1<m && y1<n){
                    int newDist=Math.max(d,Math.abs(heights[x1][y1]-heights[x][y]));
                    if(dist[x1][y1]>newDist){
                        dist[x1][y1]=newDist;
                        pq.offer(new int[]{newDist,x1,y1});
                    }
                }
            }
        }
        return 0;
    }
}