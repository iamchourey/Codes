class Solution {
    public int splitArray(int[] nums, int m) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int num:nums){
            max=Math.max(max,num);
            sum+=num;
        }
        int left=max,right=sum;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isFeasible(nums,m,mid)) right=mid-1;
            else left=mid+1;
        }
        return left;
    }
    public boolean isFeasible(int[] nums,int m,int res){
        int sum=0,parts=1;
        for(int i=0;i<nums.length;i++){
            if((sum+nums[i])<=res) sum+=nums[i];
            else{
                parts++;
                sum=nums[i];
            }
        }
        return parts<=m;
    }
}