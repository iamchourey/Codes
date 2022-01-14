class Solution {
    public int myAtoi(String s) {
        
        s=s.trim();
        
        if(s.length()==0)
            return 0;
        long rslt=0;
        int i=0;
        
        if(s.charAt(0)=='-' || s.charAt(0)=='+')
        {
            i=1;
            while(i<s.length() && Character.isDigit(s.charAt(i))==true)
            {
                rslt=rslt*10 + Character.getNumericValue(s.charAt(i));
                i++;
                if(rslt>2147483647)
                    break;
            }
            if(s.charAt(0)=='-')
                rslt=-rslt;
        }else{
          while(i<s.length() && Character.isDigit(s.charAt(i))==true)
            {
              rslt=rslt*10 + Character.getNumericValue(s.charAt(i));
              i++;
              
              if(rslt>2147483647)
                  break;
            }
        }
        
                if(rslt>2147483647)
                    rslt=2147483647;
                if(rslt<-2147483648)
                    rslt=-2147483648;
       
        return (int)rslt;
    }
}