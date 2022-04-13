class Solution {
    public int[][] generateMatrix(int n) {
        
        int matrix[][]=new int[n][n];
        
        int top=0,left=0,right=n-1,bottom=n-1,k=1;
        
        while(left<=right && top<=bottom)
        {
            for(int i=left;i<=right;i++)
                matrix[top][i]=k++;
            
            top++;
            
            for(int i=top;i<=bottom;i++)
                matrix[i][right]=k++;
            
            right--;
            
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                matrix[bottom][i]=k++;
            
                bottom--;
            }
            
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                matrix[i][left]=k++;
            
                left++;
            }
        }
        
        return matrix;
    }
}