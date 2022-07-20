class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result=0;
        
        Set<String> subsequences=new HashSet<>();
        Set<String> notSubsequences=new HashSet<>();
        
        for(String word:words){
            if(subsequences.contains(word)) result++;
            else if(notSubsequences.contains(word)) continue;
            else if(isSubsequence(s,word)){
                result++;
                subsequences.add(word);
            }
            else notSubsequences.add(word);
        }
        return result;
    }
    
    public boolean isSubsequence(String s,String word){
        int i=0,j=0;
        
        while(i<s.length() && j<word.length()){
            if(s.charAt(i)==word.charAt(j)){
                i++;
                j++;
            }
            else i++;
        }
        
        return j>=word.length();
    }
}