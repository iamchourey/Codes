class Solution {
    public boolean isValidSerialization(String preorder) {
        
        if(preorder.length()==1) return preorder.charAt(0)=='#';
        if(preorder.charAt(0)=='#') return false;
        
        int nodes=2;
        
        for(int i=1;i<preorder.length();i++){
            char c=preorder.charAt(i);
            
            if(c==',') continue;
            if(c!='#'){
                while(i<preorder.length() && preorder.charAt(i)!=',') i++;
                nodes+=2;
            }
            
            nodes--;
            if(i!=preorder.length()-1 && nodes<=0) return false;
        }
        return nodes==0;
    }
}