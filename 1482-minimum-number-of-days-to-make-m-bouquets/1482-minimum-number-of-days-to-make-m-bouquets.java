class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(m*k>n) return -1;
        int max=Integer.MIN_VALUE;
        for(int day:bloomDay) max=Math.max(max,day);
        int low=1,high=max;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isFeasible(bloomDay,m,k,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    
    public boolean isFeasible(int bloomDay[],int m,int k,int ans){
        int tempK=k,days=0,bouquets=0;
        for(int day:bloomDay){
            if(day<=ans) tempK--;
            else tempK=k;
            
            if(tempK==0){
                tempK=k;
                bouquets++;
            }
        }
        return (bouquets>=m);
    }
}