class Solution {
    public String reverseWords(String s) {
        
        char[] chars=s.toCharArray();
        int i=0,j=1;
        
        while(i<chars.length){
            while(j<chars.length && chars[j]!=' ') j++;
            reverse(chars,i,j-1);
            i=j+1;
            j=i+1;
        }
        
        return new String(chars);
    }
    
    public void reverse(char[] chars,int start,int end){
        while(start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            
            start++;
            end--;
        }
    }
}