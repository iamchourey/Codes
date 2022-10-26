class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) return -1;
        int pathLength=0,n=grid.length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0});
        int[][] dirs={{-1,1},{-1,0},{0,1},{0,-1},{1,0},{1,1},{1,-1},{-1,-1}};
        while(q.isEmpty()==false){
            int size=q.size();
            pathLength++;
            while(size-->0){
                int[] curr=q.poll();
                if(curr[0]==n-1 && curr[1]==n-1) return pathLength;
                for(int[] dir:dirs){
                    int x=dir[0]+curr[0];
                    int y=dir[1]+curr[1];
                    if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==0){
                        q.add(new int[]{x,y});
                        grid[x][y]=1;
                    }
                }
            }
        }
        return -1;
    }
}