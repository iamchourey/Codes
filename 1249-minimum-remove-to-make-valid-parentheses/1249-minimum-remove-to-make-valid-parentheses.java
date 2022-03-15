class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder str=new StringBuilder();
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c=='(')
                st.push(c);
            else if(c==')')
            {
                if(st.isEmpty())
                    continue;
                else
                    st.pop();
            }
            
            str.append(c);
        }
        StringBuilder res=new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
        {
            if(st.isEmpty()==false && str.charAt(i)=='(')
                st.pop();
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }
}