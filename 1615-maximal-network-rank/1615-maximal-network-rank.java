class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        int []indegree=new int[n];
        Set<String> set=new HashSet<>();
        
        for(int[] road:roads){
            int u=road[0];
            int v=road[1];
            indegree[u]++;
            indegree[v]++;
            String temp=Character.toString((char)(u+'0'))+Character.toString((char)(v+'0'));
            set.add(temp);
        }
        int result=0;
        
        for(int u=0;u<n-1;u++){
            for(int v=u+1;v<n;v++){
                int rank=indegree[u]+indegree[v];
                String temp1=Character.toString((char)(u+'0'))+Character.toString((char)(v+'0'));
                String temp2=Character.toString((char)(v+'0'))+Character.toString((char)(u+'0'));
                if(set.contains(temp1) || set.contains(temp2)) rank-=1;
                result=Math.max(result,rank);
            }
        }
        return result;
    }
}