class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        int even=-1;
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even++;
                int temp=nums[even];
                nums[even]=nums[i];
                nums[i]=temp;
            }
        }
        return nums;
    }
}