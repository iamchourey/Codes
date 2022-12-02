class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        int[] parent=new int[n];
        int[] rank=new int[n];
        
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(List<Integer> pair:pairs){
            union(pair.get(0),pair.get(1),parent,rank);
        }
        Map<Integer,PriorityQueue<Character>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int leader=find(i,parent);
            if(!map.containsKey(leader)) map.put(leader,new PriorityQueue<>());
            map.get(leader).add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            int leader=find(i,parent);
            sb.append(map.get(leader).poll());
        }
        return sb.toString();
    }
    public void union(int a,int b,int[] parent,int rank[]){
        int leadera=find(a,parent);
        int leaderb=find(b,parent);
        if(leadera==leaderb) return;
        if(rank[leadera]>rank[leaderb]) parent[leaderb]=leadera;
        else if(rank[leadera]<rank[leaderb]) parent[leadera]=leaderb;
        else{
            parent[leadera]=leaderb;
            rank[leaderb]++;
        }
    }
    public int find(int val,int[] parent){
        if(parent[val]==val) return val;
        return parent[val]=find(parent[val],parent);
    }
}