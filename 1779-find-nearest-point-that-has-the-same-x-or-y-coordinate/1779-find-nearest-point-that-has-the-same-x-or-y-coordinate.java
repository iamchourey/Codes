class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        
        int res=-1,minDist=Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++){
            int point[]=points[i];
            if(x==point[0] || y==point[1]){
                int dist=Math.abs(x-point[0])+Math.abs(y-point[1]);
                if(dist<minDist){
                    minDist=dist;
                    res=i;
                }
            }
        }
        return res;
    }
}