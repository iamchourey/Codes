class Solution {
    public int findPairs(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0;
        
        for(int num:nums){
            
            if(hm.containsKey(num)){
                if(k==0 && hm.get(num)==1)
                    res++;
                
                hm.put(num,hm.get(num)+1);
            }
            else{
                if(hm.containsKey(num-k))
                    res++;
                if(hm.containsKey(num+k))
                    res++;
                
                hm.put(num,1);
            }
        }
        
        return res;
    }
}