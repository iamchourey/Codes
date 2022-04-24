class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ls=new ArrayList<>();
        int open=n,close=n;
        solve(open,close,new String(),ls);
        
        return ls;
    }
    
    public void solve(int open,int close,String s,List<String> ls){
        if(open==0 && close==0){
            ls.add(new String(s));
            return;
        }
        
        if(open!=0){
            String s1=s+'(';
            solve(open-1,close,s1,ls);
        }
        
        if(close>open){
            String s2=s+')';
            solve(open,close-1,s2,ls);
        }
    }
}