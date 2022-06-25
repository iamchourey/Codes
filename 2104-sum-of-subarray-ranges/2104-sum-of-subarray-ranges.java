class Solution {
    public long subArrayRanges(int[] nums) {
        long mins=sumSubarrayMins(nums);
        for(int i=0;i<nums.length;i++) nums[i]=-nums[i];
        long maxs=sumSubarrayMins(nums);
        
        return -maxs-mins;
    }
    
    public long sumSubarrayMins(int[] arr) {
        
        Stack<Integer> stack=new Stack<>();
        long res=0;
 
        for(int i=0;i<arr.length;i++){
            while(stack.isEmpty()==false && arr[stack.peek()]>=arr[i]){
                int index=stack.pop();
                int right=i-index-1;
                int left=(stack.isEmpty()?index:index-stack.peek()-1);
                long subarrays=(long)((right+1)*(left+1));
                res+=(long)(arr[index]*subarrays);
            }
            stack.push(i);
        }
        
        while(stack.isEmpty()==false){
            int index=stack.pop();
            int right=arr.length-index-1;
            int left=(stack.isEmpty()?index:index-stack.peek()-1);
            long subarrays=(long)((right+1)*(left+1));
            res+=(long)(arr[index]*subarrays);
        }
        return res;
    }
}