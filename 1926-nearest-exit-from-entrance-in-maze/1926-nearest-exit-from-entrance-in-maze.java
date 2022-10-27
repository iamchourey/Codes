class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int result=0,m=maze.length,n=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        while(q.isEmpty()==false){
            int size=q.size();
            while(size-->0){
                int[] curr=q.poll();
                if((curr[0]!=entrance[0] || curr[1]!=entrance[1]) && 
                  (curr[0]==0 || curr[1]==0 || curr[0]==m-1 || curr[1]==n-1)) return result;
                for(int[] dir:dirs){
                    int x=dir[0]+curr[0];
                    int y=dir[1]+curr[1];
                    if(x>=0 && y>=0 && x<m && y<n && maze[x][y]=='.'){
                        q.add(new int[]{x,y});
                        maze[x][y]='+';
                    }
                }
            }
            result++;
        }
        return -1;
    }
}