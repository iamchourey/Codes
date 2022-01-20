class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        
        List<Integer> ls=new ArrayList<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            
            int maxIndex=getMaxIndex(arr,i);
            
            if(maxIndex!=i){
                
                reverse(arr,0,maxIndex);
                ls.add(maxIndex+1);
                
                reverse(arr,0,i);
                ls.add(i+1);
            }
        }
        return ls;
    }
    
    public void reverse(int[] arr,int start,int end){
        
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            
            start++;
            end--;
        }
    }
    
    public int getMaxIndex(int[] arr,int index){
        
        int maxIndex=index;
        
        for(int i=index-1;i>=0;i--){
            if(arr[i]>arr[maxIndex])
                maxIndex=i;
        }
        
        return maxIndex;
    }
}