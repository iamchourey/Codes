class Solution {
    
    public int getMax(int[] piles){
        int max=Integer.MIN_VALUE;
        
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int n=piles.length;
        int max=getMax(piles);
        
        int low=1,high=max;
        
        while(low<high){
            int mid=(low+high)/2;
            int hours=0;
            for(int pile:piles){
                hours+=(pile+mid-1)/mid;
            }
            
            if(hours>h)
                low=mid+1;
            else
                high=mid;
        }
        
        return low;
    }
}