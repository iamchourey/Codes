class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean counted[]=new boolean[n];
        int result=0;
        for(int i=0;i<n;i++){
            if(counted[i]==false){
                dfs(isConnected,i,counted);
                result++;
            }
        }
        return result;
    }
    public void dfs(int[][] connected,int src,boolean[] counted){
        if(counted[src]) return;
        counted[src]=true;
        for(int i=0;i<connected[src].length;i++){
            if(connected[src][i]==1){
                dfs(connected,i,counted);
            }
        }
    }
}