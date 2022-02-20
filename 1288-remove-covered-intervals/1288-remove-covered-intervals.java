class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                if(a[1]==b[1])
                    return b[0]-a[0];
                return a[1]-b[1];
            }
        });
        
        int n=intervals.length;
        int res=n;
        int end=intervals[n-1][1],start=intervals[n-1][0];
        for(int i=n-2;i>=0;i--){
            
            if(intervals[i][0]>=start && intervals[i][1]<=end)
                res--;
            
            end=Math.max(end,intervals[i][1]);
            start=Math.min(start,intervals[i][0]);
        }
        
        return res;
    }
}