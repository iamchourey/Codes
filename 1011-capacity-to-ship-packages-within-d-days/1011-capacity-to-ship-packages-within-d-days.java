class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,max=Integer.MIN_VALUE;
        for(int weight:weights){
            sum+=weight;
            max=Math.max(max,weight);
        }
        int low=max,high=sum;
        
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isFeasible(weights,days,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    public boolean isFeasible(int[] nums,int days,int ans){
        int day=1,sum=0;
        for(int num:nums){
            if((num+sum)>ans){
                day++;
                sum=num;
            }else sum+=num;
        }
        return (day<=days);
    }
}