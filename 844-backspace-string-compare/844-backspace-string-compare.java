class Solution {
    public boolean backspaceCompare(String s, String t) {
        String str1="",str2="";
        
        for(char c:s.toCharArray()){
            if(str1.length()>0 && c=='#') str1=str1.substring(0,str1.length()-1);
            else if(c!='#') str1+=Character.toString(c);
        }
        
        for(char c:t.toCharArray()){
            if(str2.length()>0 && c=='#') str2=str2.substring(0,str2.length()-1);
            else if(c!='#') str2+=Character.toString(c);
        }
        
        return str1.equals(str2);
    }
}