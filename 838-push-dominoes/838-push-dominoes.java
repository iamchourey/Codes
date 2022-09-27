class Solution {
    public String pushDominoes(String dominoes) {
        int n=dominoes.length();
        StringBuilder sb=new StringBuilder();
        int left[]=new int[n];
        int right[]=new int[n];
        char prev=dominoes.charAt(0);
        int count=1;
        
        for(int i=1;i<n;i++){
            if(dominoes.charAt(i)!='.'){
                prev=dominoes.charAt(i);
                count=1;
            }
            else{
                if(prev=='R'){
                    right[i]=count;
                    count++;
                }
            }
        }
        
        prev=dominoes.charAt(n-1);
        count=1;
        
        for(int i=n-2;i>=0;i--){
            if(dominoes.charAt(i)!='.'){
                prev=dominoes.charAt(i);
                count=1;
            }
            else{
                if(prev=='L'){
                    left[i]=count;
                    count++;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(dominoes.charAt(i)!='.') sb.append(dominoes.charAt(i));
            else if(left[i]==right[i]) sb.append('.');
            else if(left[i]==0) sb.append('R');
            else if(right[i]==0) sb.append('L');
            else if(left[i]>right[i]) sb.append('R');
            else sb.append('L');
        }
        
        return sb.toString();
    }
}