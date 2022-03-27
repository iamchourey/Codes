class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        int n=nums.length,left=0,right=n-1,index=-1;
        
        while(left<=right){
            index=partition(nums,left,right);
            if(index==(n-k)) return nums[index];
            else if(index>(n-k)) right=index-1;
            else left=index+1;
        }
        return -1;
    }
    public int partition(int[] nums,int left,int right){
        int index=left-1,pivot=nums[right];
        
        for(int i=left;i<right;i++){
            if(nums[i]<pivot){
                ++index;
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
            }
        }
        ++index;
        int temp=nums[right];
        nums[right]=nums[index];
        nums[index]=temp;
        
        return index;
    }
}