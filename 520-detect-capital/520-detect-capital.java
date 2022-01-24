class Solution {
    public boolean detectCapitalUse(String word) {
        
        if(word.length()==1)
            return true;
        
        boolean first=((word.charAt(0)-'A')<26);
        int capitals=0;
        
        for(char c:word.toCharArray()){
            if((c-'A')<26)
                capitals++;
        }
        
        return (capitals==word.length() || (capitals==1 && first) || capitals==0);
    }
}