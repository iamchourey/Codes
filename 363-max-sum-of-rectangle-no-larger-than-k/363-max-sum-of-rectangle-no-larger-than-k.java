class Solution {
        public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            int[] arr = new int[m];
            for(int j=i;j<n;j++){
                for(int col=0;col<m;col++){
                    arr[col] += matrix[j][col];
                }
               
                max = Math.max(max, getSubarrayMaxSum(arr,k));
            }
        }
        
        return max;
    }
         public int getSubarrayMaxSum(int[] arr, int k){
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<arr.length;i++){
            int sum = 0;
            for(int j=i;j<arr.length;j++){
                
                sum += arr[j];
              if(sum<=k){
                max = Math.max(max, sum);
            }
            }
            
            
        }
        
        return max;
    }
}