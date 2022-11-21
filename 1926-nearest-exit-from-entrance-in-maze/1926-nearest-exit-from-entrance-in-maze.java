class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int result=0,m=maze.length,n=maze[0].length;
        Queue<int[]> queue=new LinkedList<>();
        queue.add(entrance);
        maze[entrance[0]][entrance[1]]='+';
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(queue.isEmpty()==false){
            int size=queue.size();
            while(size-->0){
                int curr[]=queue.poll();
                if((curr[0]!=entrance[0] || curr[1]!=entrance[1]) && 
                   (curr[0]==0 || curr[0]==m-1 || curr[1]==0 || curr[1]==n-1)) return result;
                for(int dir[]:dirs){
                    int x=curr[0]+dir[0];
                    int y=curr[1]+dir[1];
                    if(x>=0 && y>=0 && x<m && y<n && maze[x][y]=='.'){
                        queue.add(new int[]{x,y});
                        maze[x][y]='+';
                    }
                }
            }
            result++;
        }
        return -1;
    }
}