class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int n=piles.length,max=Integer.MIN_VALUE;
        for(int pile:piles)  max=Math.max(max,pile);
        if(h==n) return max;
        int start=1,end=max;
        while(start<end){
            int mid=(start+end)/2;
            int hours=0;
            for(int pile:piles) hours+=(pile+mid-1)/mid;
            if(hours>h) start=mid+1;
            else end=mid;
        }
        return start;
    }
}