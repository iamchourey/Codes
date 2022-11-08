class Solution {
    public String makeGood(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        
        for(char c:s.toCharArray()){
            if(!stack.isEmpty() && ((c-'a')==(stack.peek()-'A') || (c-'A')==(stack.peek()-'a'))){
                stack.pop();
            }
            else stack.push(c);
        }
        while(stack.isEmpty()==false) sb.insert(0,stack.pop());
        return sb.toString();
    }
}