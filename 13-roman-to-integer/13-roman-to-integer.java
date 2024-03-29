class Solution {
     public static int giveVal(char c)
        {
            if(c=='I')
                return 1;
            if(c=='V')
                return 5;
            if(c=='X')
                return 10;
            if(c=='L')
                return 50;
            if(c=='C')
                return 100;
            if(c=='D')
                return 500;
            if(c=='M')
                return 1000;
         
         return 0;
        }
    public int romanToInt(String s) {
        
        int result=0;
        char c;
        
        
        for(int i=0;i<s.length();i++)
        {
            c=s.charAt(i);
            
            if(i<s.length()-1 && giveVal(c)<giveVal(s.charAt(i+1)))
            {
                result+=giveVal(s.charAt(i+1))-giveVal(c);
                i++;
            }else
                result+=giveVal(c);
        }
        
        return result;
    }
}