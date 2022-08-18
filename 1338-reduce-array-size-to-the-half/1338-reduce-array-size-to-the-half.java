class Solution {
    class Pair{
        int num,occurances;
        
        public Pair(int num,int occ){
            this.num=num;
            this.occurances=occ;
        }
    }
    public int minSetSize(int[] arr) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int size=arr.length;
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p2.occurances-p1.occurances;
            }
        });
        
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        int result=0;
        
        while(size>arr.length/2){
            size-=pq.poll().occurances;
            result++;
        }
        
        return result;
    }
}