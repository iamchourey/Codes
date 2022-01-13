class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int result=1;
        
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] a1,int[] a2){
                return Integer.compare(a1[0],a2[0]);
            }
        });
        
        for(int i=0;i<points.length-1;i++){
            
            if(points[i][1]<points[i+1][0]){
                ++result;
            }
            else{
                points[i+1][0]=Math.max(points[i][0],points[i+1][0]);
                points[i+1][1]=Math.min(points[i][1],points[i+1][1]);
            }
        }
        
        return result;
    }
}