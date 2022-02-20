class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        
        int start=-1,end=-1,res=0;
        
        for(int[] a:intervals){
            if(a[0]>start && a[1]>end){
                start=a[0];
                res++;
            }
            
            end=Math.max(a[1],end);
        }
        
        return res;
    }
}