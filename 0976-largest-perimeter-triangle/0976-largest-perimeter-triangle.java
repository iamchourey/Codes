class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int first=nums.length-3,second=nums.length-2,third=nums.length-1;
        
        while(first>=0){
            if(nums[first]+nums[second]>nums[third]) break;
            else{
                first--;
                second--;
                third--;
            }
        }
        return (first<0)?0:nums[first]+nums[second]+nums[third];
    }
}