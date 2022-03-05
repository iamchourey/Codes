class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int normalSum=maxSubarraySum(nums);
        if(normalSum<0)
            return normalSum;
        int totalSum=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
            nums[i]*=-1;
        }
        int circularSum=totalSum+maxSubarraySum(nums);
        return Math.max(normalSum,circularSum);
    }
    
    public int maxSubarraySum(int[] nums){
        int maxTillNow=nums[0];
        int res=nums[0];
        for(int i=1;i<nums.length;i++){
            maxTillNow=Math.max(maxTillNow+nums[i],nums[i]);
            res=Math.max(res,maxTillNow);
        }
        return res;
    }
}