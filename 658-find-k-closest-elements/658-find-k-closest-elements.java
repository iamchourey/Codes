class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        int start=0,end=arr.length-k;
        
        while(end>start){
            int mid=start+(end-start)/2;
            if(x-arr[mid]>arr[mid+k]-x) start=mid+1;
            else end=mid;
        }
        for(int i=start;i<start+k;i++) result.add(arr[i]);
        return result;
    }
}