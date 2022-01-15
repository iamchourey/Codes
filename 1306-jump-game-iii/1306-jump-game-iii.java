class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        
        while(q.isEmpty()==false){
            
            int size=q.size();
            
            while(size-->0){
                int point=q.poll();
                
                if(point-arr[point] >=0){
                    if(arr[point-arr[point]]==0)
                        return true;
                    else if(arr[point-arr[point]]>0)
                        q.add(point-arr[point]);
                }
                
                if(point+arr[point]<arr.length){
                    if(arr[point+arr[point]]==0)
                        return true;
                    else if(arr[point+arr[point]]>0)
                        q.add(point+arr[point]);
                }
                
                arr[point]=-arr[point];
            }
        }
        
        return false;
    }
}