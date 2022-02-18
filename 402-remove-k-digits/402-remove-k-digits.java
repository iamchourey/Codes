class Solution {
    public String removeKdigits(String num, int k) {
        
        if(num.charAt(0)=='0')
            return "0";
        
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            
            while(st.isEmpty()==false && k>0 && st.peek()>c){
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        //if(st.isEmpty())
          //  return "0";
        
        char[] arr=new char[st.size()];
        int index=st.size()-1;
        
        while(st.isEmpty()==false){
            arr[index--]=st.pop();
        }
        
        String res="";
        index=0;
        while(index<arr.length && arr[index]=='0')
            index++;
        
        for(int i=index;i<arr.length;i++){
            res+=Character.toString(arr[i]);
        }
        
        return res.equals("")?"0":res;
    }
}