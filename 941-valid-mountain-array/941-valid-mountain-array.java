class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if(arr.length<3)
            return false;
        
        int i=0,j=arr.length-1;
        
        while(i<arr.length-1 && arr[i]<arr[i+1]){
            i++;
        }
        
        while(j>0 && arr[j-1]>arr[j]){
            j--;
        }
        
        if(i==0 || j==0 || i>=arr.length-1 || j>=arr.length-1)
            return false;
        
        return i==j;
    }
}