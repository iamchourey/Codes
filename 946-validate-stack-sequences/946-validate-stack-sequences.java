class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        
        int push=0,pop=0;
        Stack<Integer> st=new Stack<>();
        while(push<pushed.length && pop<popped.length){
            while(push<pushed.length && (st.isEmpty() || st.peek()!=popped[pop])) st.push(pushed[push++]);
            
            if(push==pushed.length && !st.isEmpty() && st.peek()!=popped[pop]) return false;
            
            while(!st.isEmpty() && popped[pop]==st.peek()){
                st.pop();
                pop++;
            }
        }
        return st.isEmpty();
    }
}