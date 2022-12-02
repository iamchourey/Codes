class Solution {
    public int numSimilarGroups(String[] strs) {
        int result=0,n=strs.length;
        int[] parent=new int[n];
        int[] rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        for(int i=0;i<n;i++){
            //if(parent[i]!=i) continue;
            for(int j=i+1;j<n;j++){
                //if(parent[j]!=j) continue;
                if(similar(strs[i],strs[j])) union(i,j,rank,parent);
            }
        }
        for(int i=0;i<n;i++){
            if(parent[i]==i) result++;
        }
        return result;
    }
    public void union(int a,int b,int[] rank,int[] parent){
        int la=find(a,parent);
        int lb=find(b,parent);
        if(la==lb) return;
        if(rank[la]>rank[lb]) parent[lb]=la;
        else if(rank[la]<rank[lb]) parent[la]=lb;
        else{
            parent[lb]=la;
            rank[la]++;
        }
    }
    public int find(int val,int[] parent){
        if(parent[val]==val) return val;
        return parent[val]=find(parent[val],parent);
    }
    public boolean similar(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
        }
        return count==0 || count==2;
    }
}