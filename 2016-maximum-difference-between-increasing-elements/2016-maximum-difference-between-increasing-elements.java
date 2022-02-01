class Solution {
    public int maximumDifference(int[] nums) {
        
        int n=nums.length;
        int res=-1,max=nums[n-1];

        for(int i=n-2;i>=0;i--){
            max=Math.max(max,nums[i]);
            res=Math.max(res,max-nums[i]);
        }
        
        return res==0?-1:res;
    }
}