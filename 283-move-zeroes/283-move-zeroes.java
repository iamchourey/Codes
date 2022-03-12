class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums==null || nums.length==1) return;
        int i=0,j=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0) continue;
            else{
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
        }
    }
}