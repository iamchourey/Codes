class Solution {
    public double average(int[] salary) {
        
        double sum=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int sal:salary){
            sum+=(double)sal;
            min=Math.min(min,sal);
            max=Math.max(max,sal);
        }
        
        return (sum-(double)min-(double)max)/(salary.length-2);
    }
}