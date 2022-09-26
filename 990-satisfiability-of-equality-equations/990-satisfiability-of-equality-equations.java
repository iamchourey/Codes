class Solution {
    int[] parent;
    int rank[];
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        for(String equation:equations){
            if(equation.charAt(1)==equation.charAt(2)){
                union(equation.charAt(0)-'a',equation.charAt(3)-'a');
            }
        }
        for(String equation:equations){
            if(equation.charAt(1)!=equation.charAt(2)){
                int leader1=find(equation.charAt(0)-'a');
                int leader2=find(equation.charAt(3)-'a');
                
                if(leader1==leader2) return false;
            }
        }
        return true;
    }
    public void union(int a,int b){
        int leader1 = find(a);
        int leader2 = find(b);
        
        if(leader1!=leader2){
            if(rank[leader1]>rank[leader2]) parent[leader2]=leader1;
            else if(rank[leader2]>rank[leader1]) parent[leader1]=leader2;
            else {
                parent[leader1]=leader2;
                rank[leader2]++;
            }
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        int temp=find(parent[x]);
        parent[x]=temp;
        return temp;
    }
}