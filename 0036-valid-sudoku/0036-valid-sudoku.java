class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        Set<Character> s1=new HashSet<>();
        Set<Character> s2=new HashSet<>();
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                    continue;
                
                if(s1.contains(board[i][j]))
                    return false;
                else
                    s1.add(board[i][j]);
            }
            for(int j=0;j<9;j++)
            {
                if(board[j][i]=='.')
                    continue;
                
                if(s2.contains(board[j][i]))
                    return false;
                else
                    s2.add(board[j][i]);
            }
            
            if(s1.contains('0') || s2.contains('0'))
                return false;
            
            s1.clear();
            s2.clear();
        }
        
        Set<Character> s3=new HashSet<>();
        
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(j<3)
                {
                    if(board[i][j]=='.')
                        continue;
                    if(s1.contains(board[i][j]))
                        return false;
                    else
                        s1.add(board[i][j]);
                }
                else if(j<6)
                {
                    if(board[i][j]=='.')
                        continue;
                    if(s2.contains(board[i][j]))
                        return false;
                    else
                        s2.add(board[i][j]);
                }
                else
                {
                    if(board[i][j]=='.')
                        continue;
                    if(s3.contains(board[i][j]))
                        return false;
                    else
                        s3.add(board[i][j]);
                }
            }
            if(i==2 || i==5 || i==8)
                {
                    s1.clear();
                    s2.clear();
                    s3.clear();
                }
        }
        
        return true;
    }
}