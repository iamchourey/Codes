class Solution {
    public int countVowelPermutation(int n) {
        
        long dp[][]=new long[n][5];
        Arrays.fill(dp[0],1);
        
        for(int row=1;row<n;row++){
            for(int vowel=0;vowel<5;vowel++){
                if(vowel==0){
                    dp[row][vowel]=(dp[row-1][1]+dp[row-1][2]+dp[row-1][4])%1000000007;
                }
                else if(vowel==1){
                    dp[row][vowel]=(dp[row-1][0]+dp[row-1][2])%1000000007;
                }
                else if(vowel==2){
                    dp[row][vowel]=(dp[row-1][1]+dp[row-1][3])%1000000007;
                }
                else if(vowel==3){
                    dp[row][vowel]=dp[row-1][2]%1000000007;
                }
                else dp[row][vowel]=(dp[row-1][3]+dp[row-1][2])%1000000007;
            }
        }
        
        long permutations=0;
        for(int i=0;i<5;i++){
            permutations+=dp[n-1][i];
            permutations%=1000000007;
        }
        
        return (int)(permutations%1000000007);
    }
}