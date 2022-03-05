class Solution {
    public int deleteAndEarn(int[] nums) {
        
        int max=nums[0];
        for(int i=1;i<nums.length;i++)
            max=Math.max(max,nums[i]);
        
        if(max==1)
            return nums.length;
        
        int dp[]=new int[max+1];
        
        for(int i=0;i<nums.length;i++)
            dp[nums[i]]+=nums[i];
        
        dp[dp.length-2]=Math.max(dp[dp.length-2],dp[dp.length-1]);
        for(int i=dp.length-3;i>=0;i--)
            dp[i]=Math.max(dp[i+1],dp[i]+dp[i+2]);
        
        return dp[0];
    }
}