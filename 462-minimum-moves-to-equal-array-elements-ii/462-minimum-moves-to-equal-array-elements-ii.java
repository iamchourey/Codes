class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int n=nums.length;
        
        if(n%2==0){
            int res1=helper(nums,nums[n/2]);
            int res2=helper(nums,nums[n/2 - 1]);
            res=Math.min(res1,res2);
        }
        else res=helper(nums,nums[n/2]);
        
        return res;
    }
    
    public int helper(int[] nums,int val){
        int res=0;
        for(int num:nums){
            res+=Math.abs(val-num);
        }
        return res;
    }
}