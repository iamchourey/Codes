class Solution {
    public String simplifyPath(String path) {
        
        Stack<String> st=new Stack<>();
        String str[]=path.split("/");
        StringBuilder sb=new StringBuilder();
        
        for(String s:str){
            if(!st.isEmpty() && s.equals("..")) st.pop();
            else if(!s.equals("") && !s.equals(".") && !s.equals("..")) st.push(s);
        }
        if(st.isEmpty()) return "/";
        while(st.isEmpty()==false){
            sb.insert(0,st.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }
}