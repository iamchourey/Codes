class Solution {
    public boolean isPossible(int[] nums) {
        
        Map<Integer,Integer> count=new HashMap<>();
        Map<Integer,Integer> subsequenceEnd=new HashMap<>();
        
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }
        
        for(int num:nums){
            if(count.get(num)<=0) continue;
            
            if(subsequenceEnd.containsKey(num-1)){
                subsequenceEnd.put(num,subsequenceEnd.getOrDefault(num,0)+1);
                if(subsequenceEnd.get(num-1)==1) subsequenceEnd.remove(num-1);
                else subsequenceEnd.put(num-1,subsequenceEnd.get(num-1)-1);
                count.put(num,count.get(num)-1);
            }
            else if(count.containsKey(num+1) && count.containsKey(num+2) && count.get(num+1)>0 && count.get(num+2)>0){
                count.put(num,count.get(num)-1);
                count.put(num+1,count.get(num+1)-1);
                count.put(num+2,count.get(num+2)-1);
                subsequenceEnd.put(num+2,subsequenceEnd.getOrDefault(num+2,0)+1);
            }
            else return false;
        }
        return true;
    }
}