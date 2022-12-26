class Solution {
    class soldiers{
        int soldiers;
        int index;
        
        soldiers(int sol,int i){
            this.soldiers=sol;
            this.index=i;
        }
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int rows=mat.length,cols=mat[0].length;
        int res[]=new int[rows];
        
        for(int i=0;i<rows;i++){
            int j=0;
            for(;j<cols;j++){
                if(mat[i][j]==0) break;
            }
            
            res[i]=j*rows+i;
        }
        Arrays.sort(res);
        int ans[]=new int[k];
        
        for(int i=0;i<k;i++){
            ans[i]=res[i]%rows;
        }
        
        return ans;
    }
}