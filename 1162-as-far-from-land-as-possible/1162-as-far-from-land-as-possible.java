class Solution {
    public int maxDistance(int[][] grid) {
        int m=grid.length,n=grid[0].length,lands=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.add(new int[]{i,j});
                    lands++;
                }
            }
        }
        if(lands==0 || lands==m*n) return -1;
        int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
        int distance=-1;
        while(q.isEmpty()==false){
            int size=q.size();
            distance++;
            while(size-->0){
                int[] curr=q.poll();
                for(int[] dir:dirs){
                    int x=dir[0]+curr[0];
                    int y=dir[1]+curr[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==0){
                        q.add(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
            }
        }
        return distance;
    }
}