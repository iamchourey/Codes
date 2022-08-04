class Solution {
    public int mirrorReflection(int p, int q) {
        
        int lcm=p*q/gcd(p,q);
        int d=lcm/q;
        
        if(d%2==0) return 2;
        else return lcm/p%2;
    }
    
    public int gcd(int p,int q){
        return (p==0)?q:gcd(q%p,p);
    }
}