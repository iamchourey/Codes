class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int pop=0;
        Stack<Integer> st=new Stack<>();
       
        for(int push:pushed){
            st.push(push);
            while(!st.isEmpty() && st.peek()==popped[pop]){
                st.pop();
                pop++;
            }
        }
        return st.isEmpty();
    }
}