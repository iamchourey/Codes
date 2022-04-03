class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1) return;
        
        int i=1,index=-1;
        while(i<n){
            if(nums[i]>nums[i-1]) index=i;
            i++;
        }
        
        if(index==-1){
            Arrays.sort(nums);
            return;
        }
        
        int idx=index;
        for(i=index;i<n;i++){
            if(nums[i]>nums[index-1] && nums[i]<nums[index])
                idx=i;
        }
        
        int temp=nums[index-1];
        nums[index-1]=nums[idx];
        nums[idx]=temp;
        
        Arrays.sort(nums,index,n);
    }
}