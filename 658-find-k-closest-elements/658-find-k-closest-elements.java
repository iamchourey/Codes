class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> result=new ArrayList<>();
        int start=0,end=arr.length-1;
        
        while(end-start>1){
            int mid=start+(end-start)/2;
            if(arr[mid]>=x) end=mid;
            else start=mid;
        }
        
        while(result.size()<k){
            int leftVal=(start>=0)?arr[start]:Integer.MAX_VALUE/2;
            int rightVal=(end<arr.length)?arr[end]:Integer.MAX_VALUE/2;
            
            if(Math.abs(x-leftVal)<=Math.abs(rightVal-x)){
                result.add(leftVal);
                start--;
            }
            else{
                result.add(rightVal);
                end++;
            }
        }
        Collections.sort(result);
        return result;
    }
}