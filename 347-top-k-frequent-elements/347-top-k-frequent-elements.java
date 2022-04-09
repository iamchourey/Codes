class Solution {
    class Pair{
        int val;
        int freq;
        
        Pair(int v,int f){
            this.val=v;
            this.freq=f;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int res[]=new int[k];
        Map<Integer,Integer> hm=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p2.freq-p1.freq;
            }
        });
        
        for(int num:nums) hm.put(num,hm.getOrDefault(num,0)+1);
        
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        int index=0;
        while(index<k) res[index++]=pq.poll().val;
        
        return res;
        
    }
}