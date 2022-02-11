class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length()>s2.length())
            return false;
        
        char chars1[]=new char[26];
        char chars2[]=new char[26];
        
        for(char c:s1.toCharArray()){
            chars1[c-'a']++;
        }
        
        int window=s1.length();
        
        for(int i=0;i<window;i++){
            chars2[s2.charAt(i) - 'a']++;
        }
        
        if(Arrays.equals(chars1,chars2))
            return true;
        
        for(int i=window;i<s2.length();i++){
            chars2[s2.charAt(i)-'a']++;
            chars2[s2.charAt(i-window)-'a']--;
            
            if(Arrays.equals(chars1,chars2))
                return true;
        }
        
        return false;
    }
}