class Solution {
    public String smallestSubsequence(String s) {
        int count[]=new int[26];
        boolean visited[]=new boolean[26];
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            count[c-'a']--;
            if(visited[c-'a']) continue;
            
            while(!st.isEmpty() && st.peek()>c && count[st.peek()-'a']>0){
                char ch =st.pop();
                visited[ch-'a']=false;
            }
            st.push(c);
            visited[c-'a']=true;
        }
        StringBuilder str=new StringBuilder();
        while(st.isEmpty()==false){
            str.insert(0,st.pop());
        }
        return str.toString();
    }
}