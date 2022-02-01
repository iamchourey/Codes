class Solution {
    public int maxProfit(int[] prices) {
        
        int max=prices[prices.length-1];
        int maxp=0;
        
        for(int i=prices.length-2;i>=0;i--)
        {
            max=Math.max(max,prices[i+1]);
            maxp=Math.max(max-prices[i],maxp);
        }
        
        return maxp;
    }
}