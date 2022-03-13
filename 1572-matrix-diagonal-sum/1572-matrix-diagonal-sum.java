class Solution {
    public int diagonalSum(int[][] mat) {
        
        int sum=0;
        
        for(int i=0,j=0;i<mat.length;i++,j++)
        {
            sum+=mat[i][j];
        }
        
        for(int i=0,j=mat.length-1;j>=0;i++,j--)
        {
            sum+=mat[i][j];
        }
        
        if(mat.length%2!=0)
            sum-=mat[mat.length/2][mat.length/2];
        
        return sum;
    }
}