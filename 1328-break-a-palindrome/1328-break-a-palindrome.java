class Solution {
    public String breakPalindrome(String palindrome) {
        char[] chars=palindrome.toCharArray();
        int i=0;
        for(i=0;i<chars.length;i++){
            if(chars[i]!='a'){
                char temp=chars[i];
                chars[i]='a';
                if(isPalindrome(new String(chars))){
                    chars[i]=temp;
                    continue;
                }
                break;
            }
        }
        if(i>=chars.length && chars.length==1) return "";
        else if(i>=chars.length) chars[chars.length-1]='b';
        return new String(chars);
    }
    public boolean isPalindrome(String s){
        int start=0,end=s.length()-1;
        while(start<end) {
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}