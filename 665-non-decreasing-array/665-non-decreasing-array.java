class Solution {
    public boolean checkPossibility(int[] nums) {
        int lis=1;
        int[] dp=new int[nums.length];
        
        dp[0]=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[j]<=nums[i]) dp[i]=Math.max(dp[i],1+dp[j]);
            }
            lis=Math.max(dp[i],lis);
        }
        
        return (nums.length-lis)<=1;
    }
}