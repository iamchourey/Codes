class Solution {
    public int findPairs(int[] nums, int k) {
        
        HashMap<Integer,Integer> hm=new HashMap<>();
        int res=0;
        
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        
        for(int num:hm.keySet()){
            if( (k>0 && hm.containsKey(num+k)) || (k==0 && hm.get(num)>1))
                res++;
        }
        
        return res;
    }
}