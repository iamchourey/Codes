class Solution {
    public double myPow(double x, int n) {
        
        if(n==0 || x==1)
            return 1;
        if(n==1)
            return x;
        if(n<0)
            return 1/x*power(1/x,-(n+1));
        
        return power(x,n);
    }
    
    public double power(double x,int n){
        
        double res=1;
        while(n>0){
            
            if(n%2!=0)
                res*=x;
            
             x*=x;
             n=n/2;
        }
        
        return res;
    }
}