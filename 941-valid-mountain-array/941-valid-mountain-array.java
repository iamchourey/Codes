class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if(arr.length<3)
            return false;
        
        int index=0;
        
        while(index<arr.length-2 && arr[index+1]>arr[index]){
            index++;
        }
        
        if(index==0 || index>=arr.length-1)
            return false;
        
        int end=arr.length-1;
        
        while(end>index){
            if(arr[end-1]<=arr[end] || arr[end]>=arr[index])
                return false;
            
            end--;
        }
        
        return true;
    }
}