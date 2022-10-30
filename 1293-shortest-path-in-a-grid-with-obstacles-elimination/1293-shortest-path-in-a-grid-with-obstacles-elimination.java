class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m=grid.length,n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean visited[][][]=new boolean[m][n][k+2];
        int result=Integer.MAX_VALUE;
        if(grid[0][0]==1) k--;
        q.add(new int[]{0,0,k,0});
        
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        
        while(q.isEmpty()==false){
            int size=q.size();
            while(size-->0){
                int[] curr=q.poll();
                if(curr[2]<0 || visited[curr[0]][curr[1]][curr[2]]) continue;
                if(curr[0]==m-1 && curr[1]==n-1){
                    result=Math.min(result,curr[3]);
                }
                visited[curr[0]][curr[1]][curr[2]]=true;
                for(int[] dir:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && !visited[x][y][curr[2]]){
                        if(grid[x][y]!=1) q.add(new int[]{x,y,curr[2],curr[3]+1});
                        else q.add(new int[]{x,y,curr[2]-1,curr[3]+1});
                    }
                }
            }
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}