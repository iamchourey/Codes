class Solution {
    public void gameOfLife(int[][] board) {
        
        int m=board.length,n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=getLives(board,i,j);
                if(board[i][j]==1 && (lives==2 || lives==3)) board[i][j]=3;
                else if(board[i][j]==0 && lives==3) board[i][j]=2;
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]>>=1;
            }
        }
    }
    
    public int getLives(int [][]board,int i,int j){
        
        int lives=get(board,i-1,j)+get(board,i-1,j-1)+get(board,i-1,j+1)+
            get(board,i,j-1)+get(board,i,j+1)+get(board,i+1,j)+get(board,i+1,j-1)+
            get(board,i+1,j+1);
        
        return lives;
    }
    
    public int get(int [][]board,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return 0;
        
        return  board[i][j]&1;
    }
}