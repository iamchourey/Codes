class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for(int i=0,even=0;i<nums.length;i++){
            if(nums[i]%2==0){
                int temp=nums[even];
                nums[even++]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}