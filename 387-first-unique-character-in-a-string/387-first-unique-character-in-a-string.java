class Solution {
    public int firstUniqChar(String s) {
        
        int indexOfFirstUnique=Integer.MAX_VALUE;
        
        for(char c='a';c<='z';c++){
            int index=s.indexOf(c);
            if(index!=-1 && index==s.lastIndexOf(c)) 
                indexOfFirstUnique=Math.min(indexOfFirstUnique,index);
        }
        
        return indexOfFirstUnique==Integer.MAX_VALUE?-1:indexOfFirstUnique;
    }
}