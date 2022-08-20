class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        
        for(int num:nums){
            if(map.get(num)==0) continue;
            map.put(num,map.get(num)-1);
            for(int i=1;i<k;i++){
                if(map.containsKey(num+i) && map.get(num+i)>0){
                    map.put(num+i,map.get(num+i)-1);
                }
                else return false;
            }
        }
        return true;
    }
}