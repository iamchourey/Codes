class Solution {
    public String interpret(String command) {
        
        StringBuilder str=new StringBuilder();
        
        for(int i=0;i<command.length();i++){
            if(command.charAt(i)=='G') str.append('G');
            if(command.charAt(i)==')'){
                if(command.charAt(i-1)=='l') str.append("al");
                else str.append("o");
            }
        }
        return str.toString();
    }
}