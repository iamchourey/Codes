class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res=new int[2];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i]);
            if(nums[index-1]<0) res[idx++]=index;
            nums[index-1]*=-1;
        }
        for(int i=1;i<=nums.length;i++){
            if(nums[i-1]>0 && res[0]!=i) res[idx++]=i;
        }
        return res;
    }
}