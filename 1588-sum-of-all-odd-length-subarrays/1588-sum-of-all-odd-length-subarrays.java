class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        
        int sum=0,i=0,j=1;
        while(i<arr.length){
            if((i+j)%2==1){
                for(int k=i;k<j;k++) sum+=arr[k];
            }
            if(j==arr.length){
                i++;
                j=i+1;
            }else j++;
        }
        return sum;
    }
}