class Solution {
    public boolean equationsPossible(String[] equations) {
        int n=equations.length;
        int[] parent=new int[26];
        int[] rank=new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        for(String equation:equations){
            if(equation.charAt(1)==equation.charAt(2)) union(equation.charAt(0)-'a',equation.charAt(3)-'a',parent,rank);
        }
        for(String equation:equations){
            if( equation.charAt(1)!=equation.charAt(2) &&
                find(equation.charAt(0)-'a',parent)==find(equation.charAt(3)-'a',parent)) return false;
        }
        return true;
    }
    public int find(int val,int[] parent){
        if(val==parent[val]) return val;
        return parent[val]=find(parent[val],parent);
    }
    public void union(int val1,int val2,int[] parent,int [] rank){
        int leadera=find(val1,parent);
        int leaderb=find(val2,parent);
        if(leadera==leaderb) return;
        if(rank[leadera]>rank[leaderb]) parent[leaderb]=leadera;
        else if(rank[leadera]<rank[leaderb]) parent[leadera]=leaderb;
        else{
            parent[leadera]=leaderb;
            rank[leaderb]++;
        }
    }
}