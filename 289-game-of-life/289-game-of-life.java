class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int res[][]=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int lives=getLive(board,i,j);
                if(board[i][j]==1){
                    if(lives<2) res[i][j]=0;
                    else if(lives==2 || lives==3) res[i][j]=1;
                    else res[i][j]=0;
                }
                else{
                    if(lives==3) res[i][j]=1;
                    else res[i][j]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j]=res[i][j];
            }
        }
    }
    
    public int getLive(int[][] board,int i,int j){
        
        int lives=getLives(board,i-1,j)+getLives(board,i-1,j-1)+getLives(board,i-1,j+1)+getLives(board,i,j-1)+getLives(board,i,j+1)+getLives(board,i+1,j)+getLives(board,i+1,j-1)+getLives(board,i+1,j+1);
        
        return lives;
    }
    
    public int getLives(int[][] board,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return 0;
        
        return board[i][j];
    }
}