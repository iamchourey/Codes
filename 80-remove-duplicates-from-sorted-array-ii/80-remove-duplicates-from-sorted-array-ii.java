class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        for(int i = 2; i < nums.length; i++) {
            if(nums[count - 1] == nums[count] && nums[i] == nums[count]) {
                continue;
            }
            nums[++count] = nums[i];
        }
        return count + 1;
    }
}