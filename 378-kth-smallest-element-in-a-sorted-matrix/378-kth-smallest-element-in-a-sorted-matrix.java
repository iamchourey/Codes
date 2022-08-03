class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int n=matrix.length;
        int low=matrix[0][0],high=matrix[n-1][n-1];
        
        while(low<high){
            int mid=low+(high-low)/2;
            int temp=n-1;
            int count=0;
            
            for(int i=0;i<n;i++){
                while(temp>=0 && matrix[i][temp]>mid) temp--;
                count+=temp+1;
            }
            
            if(count<k) low=mid+1;
            else high=mid;
        }
        
        return low;
    }
}