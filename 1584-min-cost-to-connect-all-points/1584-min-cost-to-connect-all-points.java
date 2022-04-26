class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        PriorityQueue<Pair<int[],Integer>> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return (int)p1.getValue()-(int)p2.getValue();
            }
        });
        
        Set<Integer> hs=new HashSet<>();
        hs.add(0);
        getDistances(points,0,pq,hs);
        
        int count=0,res=0;
        
        while(count!=points.length-1){
            Pair<int[],Integer> p=pq.poll();
            int[] temp=p.getKey();
            int dist = p.getValue();
            if(hs.contains(temp[1])) continue;
            count++;
            res+=dist;
            hs.add(temp[1]);
            getDistances(points,temp[1],pq,hs);
        }
        return res;
    }
    
    public void getDistances(int[][] points,int index,PriorityQueue<Pair<int[],Integer>> pq,Set<Integer> hs){
        
        for(int i=0;i<points.length;i++){
            if(i!=index && !hs.contains(i)){
                int temp[]=new int[]{index,i};
                int dist=Math.abs(points[i][0]-points[index][0])+Math.abs(points[i][1]-points[index][1]);
                pq.add(new Pair(temp,dist));
            }
        }
    }
}