class Solution {
    class Pair{
        String str;
        int freq;
        public Pair(String s,int f){
            this.str=s;
            this.freq=f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                if(p1.freq==p2.freq) return p2.str.compareTo(p1.str);
                else return p1.freq-p2.freq;
            }
        });
        for(String word:words) map.put(word,map.getOrDefault(word,0)+1);
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k) pq.poll();
        }
        while(pq.isEmpty()==false) result.add(0,pq.poll().str);
        return result;
    }
}