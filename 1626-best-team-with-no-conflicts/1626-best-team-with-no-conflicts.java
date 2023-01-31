class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr=new int[scores.length][2];
        for(int i=0;i<ages.length;i++){
            arr[i][0]=ages[i];
            arr[i][1]=scores[i];
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        Arrays.sort(arr,(a,b)->a[0]-b[0]);

        int[] arr1 = new int[ages.length];

        int ans = 0;

        for(int i=0; i<ages.length; i++){
            int sum = arr[i][1];

            for(int j=i-1; j>=0; j--){

                if(arr[j][1]<=arr[i][1]){ sum = Math.max(sum,arr[i][1]+arr1[j]); }
            }

            arr1[i] = sum;
            ans = Math.max(ans,sum);
        }
        
        return ans;
    }
}