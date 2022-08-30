class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        
        int preSum[]=new int[s.length()+1];
        
        for(int[] shift:shifts){
            int start=shift[0];
            int end=shift[1];
            int direction=shift[2];
            
            if(direction==0){
                preSum[start]--;
                preSum[end+1]++;
            }
            else{
                preSum[start]++;
                preSum[end+1]--;
            }
        }
        
        for(int i=1;i<preSum.length;i++){
            preSum[i]+=preSum[i-1];
        }
        
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<preSum.length-1;i++){
            char c=s.charAt(i);
            int shft=preSum[i];
            char toAppend=(char)(((c-'a'+shft)%26+26)%26+'a');
            sb.append(toAppend);
        }
        return sb.toString();
    }
}