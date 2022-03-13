class Solution {
    
    public boolean match(char a,char b)
    {
        if(a=='(' && b==')' || a=='{' && b=='}' || a=='[' && b==']')
            return true;
        else
            return false;
    }
    public boolean isValid(String s) {
        
        Deque<Character> st=new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else
            {
                if(st.isEmpty())
                    return false;
                else
                {
                    if(!match(st.peek(),c))
                        return false;
                    else
                        st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}