class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        
        Stack<Character> st=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(!st.isEmpty() && c=='#') st.pop();
            else if(c!='#') st.push(c);
        }
        
        while(st.isEmpty()==false){
            sb1.insert(0,st.pop());
        }
        
        for(char c:t.toCharArray()){
            if(!st.isEmpty() && c=='#') st.pop();
            else if(c!='#') st.push(c);
        }
        
        while(st.isEmpty()==false){
            sb2.insert(0,st.pop());
        }
        
        return sb1.toString().equals(sb2.toString());
    }
}