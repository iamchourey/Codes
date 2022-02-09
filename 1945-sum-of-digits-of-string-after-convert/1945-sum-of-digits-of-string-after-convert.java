class Solution {
    public int getLucky(String s, int k) {
        
        StringBuilder str=new StringBuilder();
        
        for(char c:s.toCharArray()){
            str.append(c-'a'+1);
        }
        
        String string=str.toString();
        
        if(string.length()==1)
            return Character.getNumericValue(string.charAt(0));
        
        int res=0;
        
        while(k-- >0 && string.length()>1){
            
            res=0;
            for(char c:string.toCharArray()){
                res+=Character.getNumericValue(c);
            }
            
            string=String.valueOf(res);
        }
        
        return res;
    }
}