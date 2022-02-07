class Solution {
    public char findTheDifference(String s, String t) {
        
        for(char c:s.toCharArray()){
            t=t.replaceFirst(Character.toString(c),"");
        }
        
        return t.charAt(0);
    }
}