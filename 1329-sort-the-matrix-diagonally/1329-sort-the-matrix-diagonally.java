class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int m=mat.length,n=mat[0].length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!map.containsKey(i-j)) map.put(i-j,new ArrayList<>());
                map.get(i-j).add(mat[i][j]);
            }
        }
        
        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            Collections.sort(entry.getValue());
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(map.containsKey(i-j)){
                    int row=i,column=j;
                    List<Integer> sortedDiagonal=map.get(i-j);
                    for(int index=0;index<sortedDiagonal.size();index++){
                        mat[row][column]=sortedDiagonal.get(index);
                        row++;
                        column++;
                    }
                    map.remove(i-j);
                }
            }
        }
        return mat;
    }
}