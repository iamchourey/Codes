class Solution {
    public int largestPerimeter(int[] nums) {
        
        Arrays.sort(nums);
        
        int i=nums.length-1,j=nums.length-2,k=nums.length-3;
        
        while(k>=0)
        {
            if(nums[j]+nums[k]>nums[i])
                break;
            
            --k;
            --j;
            --i;
        }
        if(k<0)
            return 0;
        else
            return (nums[i]+nums[j]+nums[k]);
    }
}