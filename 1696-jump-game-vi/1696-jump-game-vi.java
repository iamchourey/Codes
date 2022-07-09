class Solution {
    class Pair{
        int val,index;
        public Pair(int v,int i){
            this.val=v;
            this.index=i;
        }
    }
    public int maxResult(int[] nums, int k) {
        
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);
        
        PriorityQueue<Pair> pq=new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair p1,Pair p2){
                return p2.val-p1.val;
            }
        });
        pq.add(new Pair(nums[0],0));
        dp[0]=nums[0];
        
        for(int i=1;i<n;i++){
            while(pq.peek().index<i-k) pq.poll();
            dp[i]=nums[i]+pq.peek().val;
            pq.add(new Pair(dp[i],i));
        }
        
        return dp[n-1];
    }
}