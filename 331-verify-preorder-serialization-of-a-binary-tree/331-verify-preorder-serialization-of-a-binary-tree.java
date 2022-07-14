class Solution {
    public boolean isValidSerialization(String preorder) {
        
        if(preorder.length()==1) return preorder.charAt(0)=='#';
        if(preorder.charAt(0)=='#') return false;
        
        Stack<String> stack=new Stack<>();
        String[] nodes=preorder.split(",");
        
        for(String node:nodes){
            if(node.equals("#")){
                while(stack.isEmpty()==false && stack.peek().equals("#")){
                    stack.pop();
                    if(stack.isEmpty()) return false;
                    stack.pop();
                }
                stack.push(node);
            }
            else stack.push(node);
        }
        
        return stack.size()==1 && stack.peek().equals("#");
    }
}