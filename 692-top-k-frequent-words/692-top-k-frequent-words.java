class Solution {
    class Pair{
        String s;
        int freq;
        
        Pair(String s,int f){
            this.s=s;
            this.freq=f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
           public int compare(Pair p1,Pair p2){
               if(p1.freq==p2.freq){
                   return lexico(p1.s,p2.s);
               }
               else return p2.freq-p1.freq;
           } 
        });
        
        Map<String,Integer> hm=new HashMap<>();
        
        for(String str:words) hm.put(str,hm.getOrDefault(str,0)+1);
        
        for(Map.Entry<String,Integer> entry:hm.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        
        List<String> ls=new ArrayList<>();
        for(int i=0;i<k;i++) ls.add(pq.poll().s);
        
        return ls;
        
    }
    
    public int lexico(String s1,String s2){
        int i=0;
        
        while(i<s1.length() && i<s2.length()){
            if((s1.charAt(i)-'a')!=(s2.charAt(i)-'a')) 
                return (s1.charAt(i)-'a')-(s2.charAt(i)-'a');
            
            i++;
        }
        if(i>=s1.length()) return -1;
        else return 1;
    }
}