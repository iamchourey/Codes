class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int size=arr.length;
        
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        int temp[]=new int[map.size()];
        int index=0,result=0;
        
        for(int key:map.keySet()){
            temp[index++]=map.get(key);
        }
        
        Arrays.sort(temp);
        index=temp.length-1;
        
        while(size>arr.length/2){
            size-=temp[index--];
            result++;
        }
        
        return result;
    }
}