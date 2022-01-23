class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> ls=new ArrayList<>();
        
        for(int digit=1;digit<10;digit++){
            
            int nextDigit=digit,n=digit;
            
            while(n<=high && nextDigit<10){
                if(n>=low)
                    ls.add(n);
                
                n=n*10 + ++nextDigit;
            }
        }
        
        Collections.sort(ls);
        return ls;
    }
}