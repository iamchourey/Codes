class Solution {
    public int calculate(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        int sum=0;
        int sign=1;
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            
            if(c==' ')
                continue;
            
            if(Character.isDigit(c)){
                
                int val=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    val=val*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                val*=sign;
                sum+=val;
                sign=1;
            }
            else if(c=='('){
                st.push(sum);
                st.push(sign);
                sum=0;
                sign=1;
            }
            else if(c==')'){
                sum*=st.pop();
                sum+=st.pop();
            }
            else if(c=='-'){
                sign=-1;
            }
        }
        
        return sum;
    }
}