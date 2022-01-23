class Solution {
    public int countTriples(int n) {
        
        int count=0;
        for(int i=1;i<n-1;i++){
            
            for(int j=i+1;j<n;j++){
                
                for(int k=j+1;k<=n;k++){
                    
                    int lhs=i*i+j*j;
                    int rhs=k*k;
                    
                    if(lhs==rhs)
                        count+=2;
                }
            }
        }
        
        return count;
    }
}