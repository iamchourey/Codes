class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int[][] dp=new int[nums.length][multipliers.length];
        for(int i=0;i<nums.length;i++) Arrays.fill(dp[i],Integer.MIN_VALUE);
        return helper(nums,multipliers,0,0,dp);
    }
    
    public int helper(int[] nums,int[] multiples,int start,int index,int[][] dp){
        if(index==multiples.length) return 0;
        if(dp[start][index]!=Integer.MIN_VALUE) return dp[start][index];
        int end=nums.length-1-(index-start);
        int takeStart=multiples[index]*nums[start]+helper(nums,multiples,start+1,index+1,dp);
        int takeEnd=multiples[index]*nums[end]+helper(nums,multiples,start,index+1,dp);
        return dp[start][index]=Math.max(takeStart,takeEnd);
    }
}