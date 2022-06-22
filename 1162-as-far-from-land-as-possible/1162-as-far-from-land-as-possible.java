class Solution {
    public int maxDistance(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int lands=0,waters=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    lands++;
                    q.add(new int[]{i,j});
                }
                else waters++;
            }
        }
        if(lands==0 || waters==0) return -1;
        int[][] dirs=new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        int distance=-1;
        while(q.isEmpty()==false){
            int size=q.size();
            distance++;
            while(size-->0){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==0){
                        grid[x][y]=1;
                        q.add(new int[]{x,y});
                    }
                }
            }
        }
        return distance;
    }
}