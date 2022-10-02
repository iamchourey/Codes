class Solution {
    int mod=1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] memo=new int[n+1][target+1];
        for(int i=0;i<=n;i++) Arrays.fill(memo[i],-1);
        return (int)helper(n,k,target,memo);
    }
    public long helper(int n,int k,int target,int[][] memo){
        if(n==0 && target==0) return 1;
        if(target<=0 || n<0) return 0;
        if(memo[n][target]!=-1) return memo[n][target];
        long result=0;
        for(int i=1;i<=k;i++){
            result=(result+helper(n-1,k,target-i,memo))%mod;
        }
        return memo[n][target]=(int)(result%mod);
    }
}