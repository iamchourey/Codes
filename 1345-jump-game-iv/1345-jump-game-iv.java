class Solution {
    public int minJumps(int[] arr) {
        
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        int[] ans=new int[1];
        ans[0]=Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i]))
                hm.get(arr[i]).add(i);
            else{
                hm.put(arr[i],new ArrayList<>());
                hm.get(arr[i]).add(i);
            }
        }
        
        boolean visited[]=new boolean[arr.length];
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        int jumps=0;
        
        while(q.isEmpty()==false){
            
            for(int size=q.size();size>0;--size){
                int index=q.poll();
                
                if(index==arr.length-1)
                    return jumps;
                
                List<Integer> ls=hm.get(arr[index]);
                ls.add(index+1);
                ls.add(index-1);
                
                for(int idx:ls){
                    if(idx>=0 && idx<arr.length && visited[idx]==false){
                        visited[idx]=true;
                        q.add(idx);
                    }
                }
                ls.clear();
            }
            jumps++;
        }
        return 0;
    }
}