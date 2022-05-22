class Node{
    int x,y,dist;
    char val;
    
    public Node(int x,int y,int dist,char val){
        this.x=x;
        this.y=y;
        this.dist=dist;
        this.val=val;
    }
}
class Solution {
    int[][] dirs=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int getFood(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='*'){
                    return bfs(grid,i,j,m,n);
                }
            }
        }
        return -1;
    }
    
    public int bfs(char[][] grid,int x,int y,int m,int n){
        
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(x,y,0,grid[x][y]));
        while(q.isEmpty()==false){
            Node curr=q.poll();
            if(curr.val=='#') return curr.dist;
            
            int oldx=curr.x;
            int oldy=curr.y;
            
            for(int dir[]:dirs){
                int newX=oldx+dir[0];
                int newY=oldy+dir[1];
                
                if(newX>=0 && newY>=0 && newX<m && newY<n && grid[newX][newY]!='X'){
                    q.add(new Node(newX,newY,curr.dist+1,grid[newX][newY]));
                    grid[newX][newY]='X';
                }
            }
        }
        return -1;
    }
}