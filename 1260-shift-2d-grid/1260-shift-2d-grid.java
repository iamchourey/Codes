class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length,n=grid[0].length;
        int[] temp=new int[m*n];
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                temp[index++]=grid[i][j];
            }
        }
        while(k>(m*n)) k-=m*n;
        reverse(temp,0,m*n-1);
        reverse(temp,0,k-1);
        reverse(temp,k,m*n-1);
        
        List<List<Integer>> ls=new ArrayList<>();
        int row=0;
        for(int i=0;i<m*n;){
            ls.add(new ArrayList<>());
            for(int j=0;j<n && i<m*n;j++){
                ls.get(row).add(temp[i++]);
            }
            row++;
        }
        
        return ls;
    }
    
    public void reverse(int[] temp,int start,int end){
        while(start<end){
            int a=temp[start];
            temp[start]=temp[end];
            temp[end]=a;
            
            start++;
            end--;
        }
    }
}