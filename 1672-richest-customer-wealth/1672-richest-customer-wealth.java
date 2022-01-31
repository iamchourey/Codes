class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int maxWealth=0,wealth=0;
        
        for(int i=0;i<accounts.length;i++)
        {
            for(int j=0;j<accounts[i].length;j++)
            {
                wealth+=accounts[i][j];
            }
            
            if(wealth>maxWealth)
                maxWealth=wealth;
            wealth=0;
        }
        
        return maxWealth;
    }
}