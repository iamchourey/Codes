class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int num:nums) max=Math.max(num,max);
        int low=1,high=max;
        
        //System.out.print(Math.ceil(1/5));
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isGood(nums,threshold,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean isGood(int nums[],int threshold,int divisor){
        int sum=0;
        for(int num:nums){
            sum+=(int)Math.ceil((double)num/(double)divisor);
        }
        return sum<=threshold;
    }
}