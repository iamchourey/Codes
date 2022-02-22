class Solution {
    public int titleToNumber(String columnTitle) {
        
        int ans=0;
        for(int i=0;i<columnTitle.length();i++){
            char c=columnTitle.charAt(i);
            
            ans=26*ans+(c-'A'+1);
        }
        
        return ans;
    }
}