class Solution {
    public void rotate(int[] nums, int k) {
        
        int n=nums.length;
        int temp[] =new int[n];
        int index=0;
        
        while(k>n){
            k-=n;
        }
        
        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    
    public void reverse(int[] nums,int start,int end){
        
        while(end>start){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            
            start++;
            end--;
        }
    }
}