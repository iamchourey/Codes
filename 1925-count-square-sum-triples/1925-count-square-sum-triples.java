class Solution {
    public int countTriples(int n) {
        
        int count=0;
        for(int i=1;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                
                int square=i*i+j*j;
                int k=(int)Math.sqrt(square);
                
                if(k*k==square && k<=n)
                    count+=2;
            }
        }
        
        return count;
    }
}