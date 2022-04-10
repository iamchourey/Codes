class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st=new Stack<>();
        
        for(String s:ops){
            if(s.equals("C")) st.pop();
            else if(s.equals("D")) st.push(st.peek()*2);
            else if(s.equals("+")){
                int first=st.pop();
                int second=st.pop();
                st.push(second);
                st.push(first);
                st.push(first+second);
            }
            else st.push(Integer.valueOf(s));
        }
        
        int res=0;
        while(st.isEmpty()==false) res+=st.pop();
        
        return res;
    }
}