class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int j=1;j<matrix[0].length;j++){
            int row=1,col=j;
            while(row<matrix.length && col<matrix[0].length){
                if(matrix[row][col]!=matrix[row-1][col-1]) return false;
                row++;
                col++;
            }
        }
        for(int i=2;i<matrix.length;i++){
            int row=i,col=1;
            while(row<matrix.length && col<matrix[0].length){
                if(matrix[row][col]!=matrix[row-1][col-1]) return false;
                row++;
                col++;
            }
        }
        return true;
    }
}