class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        
        int result[]=new int[queries.length];
        int index=0,sumOfEven=0;
        
        for(int num:nums) {
            if(num%2==0) sumOfEven+=num;
        }
        
        for(int[] query:queries){
            int idx=query[1];
            int val=query[0];
            
            if(nums[idx]%2==0){
                if((nums[idx]+val)%2==0) sumOfEven+=val;
                else sumOfEven-=nums[idx];
            }
            else{
                if((nums[idx]+val)%2==0) sumOfEven+=(nums[idx]+val);
            }
            result[index++]=sumOfEven;
            nums[idx]+=val;
        }
        return result;
    }
}