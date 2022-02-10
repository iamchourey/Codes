class Solution {
    public double myPow(double x, int n) {
        
        if(n==0 || x==1)
            return 1;
        if(n==1)
            return x;
        if(n<0)
            return power(1/x,n);
        
        return power(x,n);
    }
    
    public double power(double x,int n){
        
        if(x==1 || n==0)
            return 1;
        
        double temp=power(x,n/2);
        
        if(n%2==0)
            return temp*temp;
        else
            return x*temp*temp;
    }
}