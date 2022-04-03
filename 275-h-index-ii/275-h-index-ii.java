class Solution {
    public int hIndex(int[] citations) {
        
        int n=citations.length,start=0,end=n-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            if(citations[mid]==(n-mid)) return citations[mid];
            else if(citations[mid]>(n-mid)) end=mid-1;
            else start=mid+1;
        }
        return n-start;
    }
}