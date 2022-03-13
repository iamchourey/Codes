class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int m=mat.length,n=mat[0].length;
        if(m*n!=r*c) return mat;
        List<Integer> ls=new ArrayList<>();
        int ans[][]=new int[r][c];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ls.add(mat[i][j]);
            }
        }
        int index=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans[i][j]=ls.get(index++);
            }
        }
        return ans;
    }
}