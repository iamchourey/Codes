class Solution {
    public int splitArray(int[] nums, int m) {
        
        int max=Integer.MIN_VALUE,sum=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int start=max,end=sum;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isFeasible(nums,m,mid)) end=mid-1;
            else start=mid+1;
        }
        return start;
    }
    public boolean isFeasible(int nums[],int m,int ans){
        int parts=1,sum=0;
        for(int i=0;i<nums.length;i++){
            if((sum+nums[i])>ans){
                sum=nums[i];
                parts++;
            }else sum+=nums[i];
        }
        return (parts<=m);
    }
}