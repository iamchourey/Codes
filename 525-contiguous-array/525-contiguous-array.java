class Solution {
    public int findMaxLength(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                nums[i]=-1;
        }
        
        Map<Integer,Integer> hm=new HashMap<>();
        int sum=0,res=0;
        
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            
            if(sum==0)
                res=Math.max(res,i+1);
            if(hm.containsKey(sum))
                res=Math.max(res,i-hm.get(sum));
            else
                hm.put(sum,i);
        }
        
        return res;
    }
}