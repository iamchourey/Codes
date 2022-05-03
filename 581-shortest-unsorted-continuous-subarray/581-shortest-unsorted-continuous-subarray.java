class Solution {
    public int findUnsortedSubarray(int[] nums) {
        
        int start=0,end=-1;
        int min=nums[nums.length-1],max=nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]<max) end=i;
            else max=nums[i];
        }
        
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>min) start=i;
            else min=nums[i];
        }
        
        return end-start+1;
    }
}