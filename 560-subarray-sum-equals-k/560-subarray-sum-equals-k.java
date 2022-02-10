class Solution {
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer,Integer> s=new HashMap<>();
        int pre_sum=0;
        int count=0;
        
        s.put(0,1);
        
        for(int x:nums)
        {
            pre_sum+=x;
            
            if(s.containsKey(pre_sum-k))
                count+=s.get(pre_sum-k);
            
            s.put(pre_sum,s.getOrDefault(pre_sum,0)+1);
        }
        
        
        return count;
    }
}