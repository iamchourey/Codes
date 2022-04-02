class Solution {
    public String firstPalindrome(String[] words) {
        
        for(String str:words){
            if(isPalindrome(str)) return str;
        }
        return "";
    }
    public boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}