class Solution {
    public int findMaxLength(int[] nums) {
        
        int n=nums.length;
        
        if(n==0 || n==1)
            return 0;
        
        int count=0;
        
        for(int i=0;i<n;i++){
            if(nums[i]==0){        
                nums[i]=-1;
                count++;
            }
        }
        
        if(n%2==0 && count==n/2)
            return n;
        
        Map<Integer,Integer> hm=new HashMap<>();
        int sum=0,res=0;
        
        for(int i=0;i<n;i++){
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