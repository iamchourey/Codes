class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>> ls=new ArrayList<>();
        int m=grid.length,n=grid[0].length;
        k%=(m*n);
        int start=(m*n)-k;
        int index=-1;
        for(int i=start;i<m*n+start;i++){
            int j=i%(m*n),row=j/n,col=j%n;
            
            if((i-start)%n==0){
                ls.add(new ArrayList<>());
                index++;
            }
            
            ls.get(index).add(grid[row][col]);
        }
        
        return ls;
    }
}