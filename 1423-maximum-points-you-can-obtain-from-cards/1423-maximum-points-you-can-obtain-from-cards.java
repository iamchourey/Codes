class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int total=0,minSubSum=Integer.MAX_VALUE,currWin=0,j=0;
        int n=cardPoints.length;
        for(int points:cardPoints) total+=points;
        
        for(int i=0;i<n-k;i++){
            currWin+=cardPoints[i];
        }
        
        for(int i=n-k;i<cardPoints.length;i++){
            minSubSum=Math.min(minSubSum,currWin);
            currWin=currWin-cardPoints[j++]+cardPoints[i];
        }
        minSubSum=Math.min(minSubSum,currWin);
        return total-minSubSum;
     }
}