class Solution {
    class Pair{
        int val,idx;
        public Pair(int v,int i){
            this.val=v;
            this.idx=i;
        }
    }
    public int minFallingPathSum(int[][] grid) {
        
        Pair min1=new Pair(Integer.MAX_VALUE,-1);
        Pair min2=new Pair(Integer.MAX_VALUE,-1);
        
        for(int i=0;i<grid.length;i++){
            if(grid[0][i]<min1.val){
                min2=min1;
                min1=new Pair(grid[0][i],i);
            }
            else if(grid[0][i]<min2.val){
                min2=new Pair(grid[0][i],i);
            }
        }
        
        for(int i=1;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(j!=min1.idx){
                    grid[i][j]+=min1.val;
                }
                else grid[i][j]+=min2.val;
            }
            
            min1.val=Integer.MAX_VALUE;
            min2.val=Integer.MAX_VALUE;
            
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]<min1.val){
                    min2=min1;
                    min1=new Pair(grid[i][j],j);
                }
                else if(grid[i][j]<min2.val){
                    min2=new Pair(grid[i][j],j);
                }
            }
        }
        return min1.val;
    }
}