class Solution {
    public boolean validPalindrome(String s) {
      int lptr = 0;
      int rptr = s.length() - 1 ;
      if(s.length() <= 2) return true;
        while(lptr < rptr )
        {
            if(s.charAt(lptr) != s.charAt(rptr))
          {
            break; 
          }
          else
          {
              rptr--;
              lptr++;
          }
        }
        if(lptr >= rptr) return true;
       return isPalindrome(s.substring(lptr, rptr)) || isPalindrome(s.substring(lptr+1,rptr +1 ));
    }
    
  private boolean isPalindrome(String str)
  {
      if(str.length() == 1) return true;
      int l = 0;
      int r = str.length() - 1;
      while(l < r && str.charAt(l) == str.charAt(r))
      {
          r--;
          l++;
      }
      return l >= r;
  }
}