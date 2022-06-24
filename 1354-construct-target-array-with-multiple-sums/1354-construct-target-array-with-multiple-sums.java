class Solution {
    public boolean isPossible(int[] target) {
        
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        long sum=0;
        for(int num:target){
            pq.add((long)num);
            sum+=num;
        }
        
        while(pq.peek()>1){
            long temp=pq.poll();
            long remSum=sum-temp;
            if(temp==1 || remSum==1) return true;
            if(remSum==0 || remSum>temp) return false;
            temp=temp%remSum;
            if(temp<1) return false;
            sum=remSum+temp;
            pq.add(temp);
        }
        return true;
    }
}