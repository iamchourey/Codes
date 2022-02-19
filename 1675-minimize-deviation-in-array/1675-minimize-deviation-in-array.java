class Solution {
    public int minimumDeviation(int[] nums) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        
        for(int num:nums){
            if(num%2!=0)
                num*=2;
            min=Math.min(min,num);
            pq.add(num);
        }
        
        int diff=Integer.MAX_VALUE;
        
        while(pq.peek()%2==0){
            int max=pq.remove();
            diff=Math.min(diff,max-min);
            min=Math.min(min,max/2);
            pq.add(max/2);
        }
        
        return Math.min(diff,pq.peek()-min);
        
    }
}