class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        int n=changed.length;
        if(n%2!=0) return new int[0];
        int result[]=new int[n/2];
        int index=0;
        
        Arrays.sort(changed);
        Map<Integer,Integer> map=new HashMap<>();
        
        for(int num:changed) map.put(num,map.getOrDefault(num,0)+1);
        
        for(int num:changed){
            if(map.containsKey(num)){
                result[index++]=num;
                if(map.containsKey(num*2)){
                    map.put(num*2,map.get(num*2)-1);
                    if(map.get(num*2)==0) map.remove(num*2);
                }else return new int[0];
                
                if(!map.containsKey(num)) return new int[0];
                map.put(num,map.get(num)-1);
                if(map.get(num)==0) map.remove(num);
            }
        }
        
        return result;
    }
}