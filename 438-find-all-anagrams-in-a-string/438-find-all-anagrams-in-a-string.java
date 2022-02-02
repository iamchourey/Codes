class Solution {
    
    public boolean compare(int[] freq1,int[] freq2){
        
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i])
                return false;
        }
        
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        
        
        List<Integer> ls=new ArrayList<>();
        if(s.length()<p.length())
            return ls;
        
        int[] freq=new int[26];
        for(char c:p.toCharArray()){
            freq[c-'a']++;
        }
        
        int window=p.length();
        int freq2[]=new int[26];
        int n=s.length();
        
        for(int i=0;i<window;i++){
            freq2[s.charAt(i)-'a']++;
        }
        for(int i=window;i<n;i++){
            
            if(compare(freq,freq2))
                ls.add(i-window);
            
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-window)-'a']--;
        }
        
        if(compare(freq,freq2))
            ls.add(n-window);
        
        return ls;
    }
}